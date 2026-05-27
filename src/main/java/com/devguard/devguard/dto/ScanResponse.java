package com.devguard.devguard.dto;

import com.devguard.devguard.engine.DetectionResult;

import java.util.List;

public class ScanResponse {
    private int riskScore;
    private int totalFindings;
    private List<DetectionResult> results;

    public ScanResponse(int totalFindings, int riskScore, List<DetectionResult> results) {
        this.totalFindings = totalFindings;
        this.riskScore = riskScore;
        this.results = results;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(int riskScore) {
        this.riskScore = riskScore;
    }

    public int getTotalFindings() {
        return totalFindings;
    }

    public List<DetectionResult> getResults() {
        return results;
    }
}
