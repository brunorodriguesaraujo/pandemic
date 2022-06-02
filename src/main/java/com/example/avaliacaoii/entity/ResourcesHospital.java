package com.example.avaliacaoii.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "recursos")
@Data
public class ResourcesHospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int doctor;
    private int nurse;
    private int respirator;
    private int tomography;
    private int ambulance;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
}
