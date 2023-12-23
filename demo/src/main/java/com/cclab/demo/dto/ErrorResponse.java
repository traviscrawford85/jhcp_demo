package com.cclab.demo.dto;

public class ErrorResponse {
    private final String message;
    private final long timestamp;

    public ErrorResponse(String message, long timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    // Getters and Setters

}
