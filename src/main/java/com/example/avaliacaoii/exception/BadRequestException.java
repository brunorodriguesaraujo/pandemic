package com.example.avaliacaoii.exception;


import lombok.Getter;

public class BadRequestException extends Exception {

    @Getter
    private String errorCode;
    public BadRequestException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
