package com.example.avaliacaoii.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ErrorResponse {
    int httpCode;
    String message;
    String internalCode;
    List<FieldErrorResponse> erros;
}
