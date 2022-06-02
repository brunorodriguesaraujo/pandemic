package com.example.avaliacaoii.controller.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class PostHospitalRequest {
    @NotEmpty(message = "nome deve ser informado")
    private String name;
    @NotEmpty(message = "endereço deve ser informado")
    private String address;
    @NotEmpty(message = "cnpj deve ser informado")
    private String cnpj;
    @NotNull(message = "percentual deve ser informado")
    private int percent;
}
