package com.example.avaliacaoii.enums;

public enum Errors {
    ML101("ML-101", "Hospital [%s] não existe");

    private final String code;
    private final String message;

    Errors(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
