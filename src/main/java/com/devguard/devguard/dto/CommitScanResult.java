package com.devguard.devguard.dto;

public class CommitScanResult {

    private String commitHash;
    private String commitAuthor;
    private String commitDate;

    private String fileName;

    private String secretType;
    private String severity;

    public CommitScanResult() {
    }

    public String getCommitHash() {
        return commitHash;
    }

    public void setCommitHash(String commitHash) {
        this.commitHash = commitHash;
    }

    public String getCommitAuthor() {
        return commitAuthor;
    }

    public void setCommitAuthor(String commitAuthor) {
        this.commitAuthor = commitAuthor;
    }

    public String getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(String commitDate) {
        this.commitDate = commitDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSecretType() {
        return secretType;
    }

    public void setSecretType(String secretType) {
        this.secretType = secretType;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }
}