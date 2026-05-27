package com.devguard.devguard.engine;

public class DetectionResult {
    private int lineNumber;
    private String type;
    private String severity;
    private String matchedValue;
    private String lineContent;

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
