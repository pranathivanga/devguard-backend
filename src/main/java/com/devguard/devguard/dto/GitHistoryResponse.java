package com.devguard.devguard.dto;

import java.util.List;

public class GitHistoryResponse {

    private int commitsAnalyzed;
    private int totalFindings;

    private List<CommitScanResult> findings;

    public GitHistoryResponse() {
    }

    public GitHistoryResponse(
            int commitsAnalyzed,
            int totalFindings,
            List<CommitScanResult> findings) {

        this.commitsAnalyzed = commitsAnalyzed;
        this.totalFindings = totalFindings;
        this.findings = findings;
    }

    public int getCommitsAnalyzed() {
        return commitsAnalyzed;
    }

    public void setCommitsAnalyzed(int commitsAnalyzed) {
        this.commitsAnalyzed = commitsAnalyzed;
    }

    public int getTotalFindings() {
        return totalFindings;
    }

    public void setTotalFindings(int totalFindings) {
        this.totalFindings = totalFindings;
    }

    public List<CommitScanResult> getFindings() {
        return findings;
    }

    public void setFindings(List<CommitScanResult> findings) {
        this.findings = findings;
    }
}