package com.example.avaliacaoii.controller.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class PostResourcesHospitalRequest {
    @Positive
    private int doctor;
    @Positive
    private int nurse;
    @Positive
    private int respirator;
    @Positive
    private int tomography;
    @Positive
    private int ambulance;
    @NotNull(message = "hospital deve ser informado")
    @JsonAlias("hospital_id")
    private int hospitalId;
}
