package com.example.banksystemproject.ExceptionHandler;

public class ApiRequestException extends RuntimeException {
    public ApiRequestException(String message) {
        super(message);
    }
}
