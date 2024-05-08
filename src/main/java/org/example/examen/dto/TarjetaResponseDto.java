package org.example.examen.dto;

public class TarjetaResponseDto {
    private int statusCode;
    private String message;

    // Constructor
    public TarjetaResponseDto(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    // Getters y Setters
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}