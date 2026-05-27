package com.devguard.devguard.dto;


import com.devguard.devguard.engine.DetectionResult;
import java.util.List;

public class FileReport {

    private String fileName;
    private List<DetectionResult> findings;

    public FileReport(String fileName, List<DetectionResult> findings) {
        this.fileName = fileName;
        this.findings = findings;
    }

    public String getFileName() {
        return fileName;
    }

    public List<DetectionResult> getFindings() {
        return findings;
    }
}