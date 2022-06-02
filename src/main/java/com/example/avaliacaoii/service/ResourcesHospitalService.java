package com.example.avaliacaoii.service;

import com.example.avaliacaoii.entity.ResourcesHospital;
import com.example.avaliacaoii.repository.HospitalRepository;
import com.example.avaliacaoii.repository.ResourcesHospitalRepository;
import org.springframework.stereotype.Service;

@Service
public class ResourcesHospitalService extends ResourcesAverage {

    private final ResourcesHospitalRepository repository;
    private final HospitalRepository repositoryHospital;

    public ResourcesHospitalService(ResourcesHospitalRepository repository, HospitalRepository repositoryHospital) {
        this.repository = repository;
        this.repositoryHospital = repositoryHospital;
    }

    public void save(ResourcesHospital resources) {
        repository.save(resources);
    }

    public String getAverageResource() {
        return getAverageResource(repository.findAll());
    }
}
