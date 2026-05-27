package com.devguard.devguard.dto;

public class CiResponse {

    private String status;
    private String message;
    private int highCount;

    public CiResponse(String status, String message, int highCount) {
        this.status = status;
        this.message = message;
        this.highCount = highCount;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public int getHighCount() {
        return highCount;
    }
}