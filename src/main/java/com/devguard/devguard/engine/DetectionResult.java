package com.devguard.devguard.engine;

public class DetectionResult {
    private int lineNumber;
    private String type;
    private String severity;
    private String matchedValue;
    private String lineContent;
    private String recommendation;

    private String aiExplanation;

    private String category;

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setMatchedValue(String matchedValue) {
        this.matchedValue = matchedValue;
    }

    public void setLineContent(String lineContent) {
        this.lineContent = lineContent;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getAiExplanation() {
        return aiExplanation;
    }

    public void setAiExplanation(String aiExplanation) {
        this.aiExplanation = aiExplanation;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public DetectionResult(int lineNumber, String type, String severity, String matchedValue, String lineContent) {
        this.lineNumber = lineNumber;
        this.type = type;
        this.severity = severity;
        this.matchedValue = matchedValue;
        this.lineContent = lineContent;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String getType() {
        return type;
    }

    public String getSeverity() {
        return severity;
    }

    public String getMatchedValue() {
        return matchedValue;
    }

    public String getLineContent() {
        return lineContent;
    }

}
