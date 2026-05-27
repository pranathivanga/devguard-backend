package com.devguard.devguard.dto;

import java.util.List;

public class ScanResponse {

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
}