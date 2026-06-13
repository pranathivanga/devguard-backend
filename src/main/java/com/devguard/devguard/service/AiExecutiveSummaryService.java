package com.devguard.devguard.service;

import com.devguard.devguard.dto.ScanMetrics;
import com.devguard.devguard.engine.DetectionResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AiExecutiveSummaryService {

    public String generateSummary(
            ScanMetrics metrics,
            List<DetectionResult> findings) {

        return "Repository analysis detected "
                + findings.size()
                + " potential secret(s), including "
                + metrics.getHighCount()
                + " high severity issue(s). Overall security score is "
                + metrics.getSecurityScore()
                + "/100 ("
                + metrics.getRiskLevel()
                + "). Immediate remediation of critical credentials is recommended.";
    }
}