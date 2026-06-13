package com.devguard.devguard.service;

import com.devguard.devguard.dto.ScanMetrics;
import com.devguard.devguard.engine.DetectionResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskScoringService {

    public ScanMetrics calculateMetrics(
            List<DetectionResult> results,
            int totalFiles,
            long durationMs) {

        int high = 0;
        int medium = 0;
        int low = 0;

        for (DetectionResult r : results) {
            switch (r.getSeverity()) {
                case "HIGH" -> high++;
                case "MEDIUM" -> medium++;
                case "LOW" -> low++;
            }
        }

        int score = 100 - (high * 15) - (medium * 7) - (low * 3);

        if (score < 0) score = 0;
        if (score > 100) score = 100;

        String riskLevel;
        if (score >= 90) riskLevel = "SECURE";
        else if (score >= 75) riskLevel = "LOW";
        else if (score >= 50) riskLevel = "MODERATE";
        else if (score >= 25) riskLevel = "HIGH";
        else riskLevel = "CRITICAL";

        ScanMetrics metrics = new ScanMetrics();
        metrics.setTotalFiles(totalFiles);
        metrics.setTotalSecrets(results.size());
        metrics.setHighCount(high);
        metrics.setMediumCount(medium);
        metrics.setLowCount(low);
        metrics.setSecurityScore(score);
        metrics.setRiskLevel(riskLevel);
        metrics.setScanDurationMs(durationMs);

        return metrics;
    }
}