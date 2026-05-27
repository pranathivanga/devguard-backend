package com.devguard.devguard.service;

import com.devguard.devguard.dto.CiResponse;
import com.devguard.devguard.dto.FileReport;
import com.devguard.devguard.dto.ScanResponse;
import com.devguard.devguard.engine.DetectionResult;
import com.devguard.devguard.engine.SecretDetector;
import com.devguard.devguard.model.ScanRecord;
import com.devguard.devguard.repository.ScanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.eclipse.jgit.api.Git;
import java.io.File;
import java.nio.file.Files;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
public class ScanService {

    @Autowired
    private ScanRepository repository;

    public ScanResponse scanText(String content) {

        List<DetectionResult> results = SecretDetector.scan(content);

        int riskScore = 0;
        int high = 0, medium = 0, low = 0;

        for (DetectionResult r : results) {

            riskScore += getScore(r.getSeverity());

            switch (r.getSeverity()) {
                case "HIGH" -> high++;
                case "MEDIUM" -> medium++;
                case "LOW" -> low++;
            }
        }

        // Save to DB
        ScanRecord record = new ScanRecord();
        record.setFileName("manual-input");
        record.setTotalFindings(results.size());
        record.setHighCount(high);
        record.setMediumCount(medium);
        record.setLowCount(low);
        record.setRiskScore(riskScore);
        record.setTimestamp(LocalDateTime.now());

        repository.save(record);

        // 🔥 FIX: wrap results into FileReport
        List<FileReport> fileReports = new ArrayList<>();
        fileReports.add(new FileReport("manual-input", results));

        return new ScanResponse(
                1,                  // totalFiles
                results.size(),     // totalFindings
                riskScore,
                fileReports
        );
    }

    private int getScore(String severity) {
        switch (severity) {
            case "HIGH": return 5;
            case "MEDIUM": return 3;
            case "LOW": return 1;
            default: return 0;
        }
    }
    public CiResponse scanForCI(String content) {

        List<DetectionResult> results = SecretDetector.scan(content);

        int highCount = 0;

        for (DetectionResult r : results) {
            if ("HIGH".equals(r.getSeverity())) {
                highCount++;
            }
        }

        if (highCount > 0) {
            return new CiResponse(
                    "FAILED",
                    "Build blocked due to high severity secrets",
                    highCount
            );
        } else {
            return new CiResponse(
                    "PASSED",
                    "No high severity secrets found",
                    0
            );
        }
    }
    public ScanResponse scanZip(MultipartFile file) throws IOException {

        Map<String, List<DetectionResult>> fileMap = new HashMap<>();

        ZipInputStream zis = new ZipInputStream(file.getInputStream());
        ZipEntry entry;

        while ((entry = zis.getNextEntry()) != null) {

            if (!entry.isDirectory() && isValidFile(entry.getName())) {

                String content = new String(zis.readAllBytes());

                List<DetectionResult> results = SecretDetector.scan(content);

                if (!results.isEmpty()) {
                    fileMap.put(entry.getName(), results);
                }
            }
        }

        zis.close();

        // 🔥 MODULE 2 LOGIC STARTS HERE

        List<FileReport> fileReports = new ArrayList<>();

        int totalFindings = 0;
        int riskScore = 0;

        for (Map.Entry<String, List<DetectionResult>> entrySet : fileMap.entrySet()) {

            fileReports.add(new FileReport(entrySet.getKey(), entrySet.getValue()));

            for (DetectionResult r : entrySet.getValue()) {
                totalFindings++;
                riskScore += getScore(r.getSeverity());
            }
        }

        // save to DB
        ScanRecord record = new ScanRecord();
        record.setFileName(file.getOriginalFilename());
        record.setTotalFindings(totalFindings);
        record.setRiskScore(riskScore);
        record.setTimestamp(LocalDateTime.now());

        repository.save(record);

        return new ScanResponse(
                fileReports.size(),
                totalFindings,
                riskScore,
                fileReports
        );
    }
    private boolean isValidFile(String name) {
        return name.endsWith(".java") ||
                name.endsWith(".txt") ||
                name.endsWith(".properties") ||
                name.endsWith(".env");
    }
    public ScanResponse scanGithubRepo(String repoUrl) throws Exception {

        File tempDir = Files.createTempDirectory("repo").toFile();

        // clone repo
        Git.cloneRepository()
                .setURI(repoUrl)
                .setDirectory(tempDir)
                .call();

        Map<String, List<DetectionResult>> fileMap = new HashMap<>();

        scanDirectory(tempDir, fileMap);

        List<FileReport> fileReports = new ArrayList<>();

        int totalFindings = 0;
        int riskScore = 0;

        for (Map.Entry<String, List<DetectionResult>> entry : fileMap.entrySet()) {

            fileReports.add(new FileReport(entry.getKey(), entry.getValue()));

            for (DetectionResult r : entry.getValue()) {
                totalFindings++;
                riskScore += getScore(r.getSeverity());
            }
        }

        return new ScanResponse(
                fileReports.size(),
                totalFindings,
                riskScore,
                fileReports
        );
    }
    private void scanDirectory(File dir, Map<String, List<DetectionResult>> fileMap) throws IOException {

        File[] files = dir.listFiles();

        if (files == null) return;

        for (File file : files) {

            if (file.isDirectory()) {

                scanDirectory(file, fileMap);

            } else if (isValidFile(file.getName())) {

                String content = Files.readString(file.toPath());

                List<DetectionResult> results = SecretDetector.scan(content);

                if (!results.isEmpty()) {
                    fileMap.put(file.getAbsolutePath(), results);
                }
            }
        }
    }
}