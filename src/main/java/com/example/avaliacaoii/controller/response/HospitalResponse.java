package com.example.avaliacaoii.controller.response;

import lombok.Data;

@Data
public class HospitalResponse {
    private String name;
    private String address;
    private String cnpj;
    private int percent;
}
