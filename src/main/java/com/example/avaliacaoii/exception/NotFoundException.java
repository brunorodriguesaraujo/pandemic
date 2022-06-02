package com.example.avaliacaoii.exception;

import lombok.Getter;

public class NotFoundException extends Exception {

    @Getter
    private String errorCode;

    public NotFoundException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}