package com.devguard.devguard.dto;

public class DashboardSummary {

    private long totalScans;
    private long totalSecrets;
    private double averageSecurityScore;

    private long highSeverityCount;
    private long mediumSeverityCount;
    private long lowSeverityCount;

    public DashboardSummary() {
    }

    public long getTotalScans() {
        return totalScans;
    }

    public void setTotalScans(long totalScans) {
        this.totalScans = totalScans;
    }

    public long getTotalSecrets() {
        return totalSecrets;
    }

    public void setTotalSecrets(long totalSecrets) {
        this.totalSecrets = totalSecrets;
    }

    public double getAverageSecurityScore() {
        return averageSecurityScore;
    }

    public void setAverageSecurityScore(double averageSecurityScore) {
        this.averageSecurityScore = averageSecurityScore;
    }

    public long getHighSeverityCount() {
        return highSeverityCount;
    }

    public void setHighSeverityCount(long highSeverityCount) {
        this.highSeverityCount = highSeverityCount;
    }

    public long getMediumSeverityCount() {
        return mediumSeverityCount;
    }

    public void setMediumSeverityCount(long mediumSeverityCount) {
        this.mediumSeverityCount = mediumSeverityCount;
    }

    public long getLowSeverityCount() {
        return lowSeverityCount;
    }

    public void setLowSeverityCount(long lowSeverityCount) {
        this.lowSeverityCount = lowSeverityCount;
    }
}