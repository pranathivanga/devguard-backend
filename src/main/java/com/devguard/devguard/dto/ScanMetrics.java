package com.devguard.devguard.dto;

public class ScanMetrics {

    private int totalFiles;
    private int totalSecrets;

    private int highCount;
    private int mediumCount;
    private int lowCount;

    private int securityScore;
    private String riskLevel;

    private long scanDurationMs;

    public ScanMetrics() {
    }

    public int getTotalFiles() { return totalFiles; }
    public void setTotalFiles(int totalFiles) { this.totalFiles = totalFiles; }

    public int getTotalSecrets() { return totalSecrets; }
    public void setTotalSecrets(int totalSecrets) { this.totalSecrets = totalSecrets; }

    public int getHighCount() { return highCount; }
    public void setHighCount(int highCount) { this.highCount = highCount; }

    public int getMediumCount() { return mediumCount; }
    public void setMediumCount(int mediumCount) { this.mediumCount = mediumCount; }

    public int getLowCount() { return lowCount; }
    public void setLowCount(int lowCount) { this.lowCount = lowCount; }

    public int getSecurityScore() { return securityScore; }
    public void setSecurityScore(int securityScore) { this.securityScore = securityScore; }

    public String getRiskLevel() { return riskLevel; }
    public void setRiskLevel(String riskLevel) { this.riskLevel = riskLevel; }

    public long getScanDurationMs() { return scanDurationMs; }
    public void setScanDurationMs(long scanDurationMs) { this.scanDurationMs = scanDurationMs; }
}