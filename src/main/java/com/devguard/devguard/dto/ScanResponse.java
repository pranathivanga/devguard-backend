package com.devguard.devguard.dto;

import com.devguard.devguard.engine.DetectionResult;

import java.util.List;

public class ScanResponse {
    private ScanMetrics metrics;

    private String aiExecutiveSummary;

    private List<DetectionResult> findings;
    private int totalFiles;
    private int totalFindings;
    private int riskScore;
    private List<FileReport> files;

    public ScanResponse(int totalFiles, int totalFindings, int riskScore, List<FileReport> files) {
        this.totalFiles = totalFiles;
        this.totalFindings = totalFindings;
        this.riskScore = riskScore;
        this.files = files;
    }

    public int getTotalFiles() {
        return totalFiles;
    }

    public int getTotalFindings() {
        return totalFindings;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public List<FileReport> getFiles() {
        return files;
    }

    public ScanMetrics getMetrics() {
        return metrics;
    }

    public void setMetrics(ScanMetrics metrics) {
        this.metrics = metrics;
    }

    public void setFiles(List<FileReport> files) {
        this.files = files;
    }

    public void setRiskScore(int riskScore) {
        this.riskScore = riskScore;
    }

    public void setTotalFindings(int totalFindings) {
        this.totalFindings = totalFindings;
    }

    public void setTotalFiles(int totalFiles) {
        this.totalFiles = totalFiles;
    }

    public List<DetectionResult> getFindings() {
        return findings;
    }

    public void setFindings(List<DetectionResult> findings) {
        this.findings = findings;
    }

    public String getAiExecutiveSummary() {
        return aiExecutiveSummary;
    }

    public void setAiExecutiveSummary(String aiExecutiveSummary) {
        this.aiExecutiveSummary = aiExecutiveSummary;
    }
}