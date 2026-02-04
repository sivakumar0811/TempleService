package com.tutasi.dto;

import java.time.LocalDateTime;

public class ApiErrorResponse {

	private String message;
    private String path;
    private int status;
    private LocalDateTime timestamp;
    
    public ApiErrorResponse() {}

    public ApiErrorResponse(String message, String path, int status, LocalDateTime timestamp) {
        this.message = message;
        this.path = path;
        this.status = status;
        this.timestamp = timestamp;
    }
    
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
    
    
}
