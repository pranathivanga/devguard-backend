package com.devguard.devguard.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class TrackedRepository {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String repoName;

    private String repoUrl;

    private Integer lastSecurityScore;

    private LocalDateTime lastScanTime;

    private String status;

    public TrackedRepository() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public String getRepoUrl() {
        return repoUrl;
    }

    public void setRepoUrl(String repoUrl) {
        this.repoUrl = repoUrl;
    }

    public Integer getLastSecurityScore() {
        return lastSecurityScore;
    }

    public void setLastSecurityScore(Integer lastSecurityScore) {
        this.lastSecurityScore = lastSecurityScore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getLastScanTime() {
        return lastScanTime;
    }

    public void setLastScanTime(LocalDateTime lastScanTime) {
        this.lastScanTime = lastScanTime;
    }
// Generate getters and setters
}
