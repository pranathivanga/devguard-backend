package com.devguard.devguard.dto;

public class RepositoryHealthResponse {

    private int securityScore;
    private int secretsFound;
    private String riskLevel;
    private String recommendation;

    public int getSecurityScore() {
        return securityScore;
    }

    public void setSecurityScore(int securityScore) {
        this.securityScore = securityScore;
    }

    public int getSecretsFound() {
        return secretsFound;
    }

    public void setSecretsFound(int secretsFound) {
        this.secretsFound = secretsFound;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}