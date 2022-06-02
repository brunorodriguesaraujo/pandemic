package com.example.avaliacaoii.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "hospital")
@Data
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String cnpj;
    private int percent;
    private LocalDateTime dateTime = LocalDateTime.now();

    @OneToMany(mappedBy = "hospital")
    private List<ResourcesHospital> resources;
}
