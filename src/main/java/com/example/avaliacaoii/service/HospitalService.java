package com.example.avaliacaoii.service;

import com.example.avaliacaoii.controller.request.PercentRequest;
import com.example.avaliacaoii.entity.Hospital;
import com.example.avaliacaoii.enums.Errors;
import com.example.avaliacaoii.exception.NotFoundException;
import com.example.avaliacaoii.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class HospitalService {

    private final HospitalRepository repository;

    public HospitalService(HospitalRepository repository) {
        this.repository = repository;
    }

    public void save(Hospital hospital) {
        repository.save(hospital);
    }

    public double percentLarger() {
        List<Hospital> hospitals = new ArrayList<>();
        for (Hospital hospital : repository.findAll()) {
            if (hospital.getPercent() > 90) {
                hospitals.add(hospital);
            }
        }
        double sizeHospitals = repository.findAll().size();
        double sizeHospitalLarger = hospitals.size();
        return (sizeHospitalLarger / sizeHospitals) * 100;
    }

    public double percentSmaller() {
        List<Hospital> hospitals = new ArrayList<>();
        for (Hospital hospital : repository.findAll()) {
            if (hospital.getPercent() < 90) {
                hospitals.add(hospital);
            }
        }
        double sizeHospitals = repository.findAll().size();
        double sizeHospitalSmaller = hospitals.size();
        return (sizeHospitalSmaller / sizeHospitals) * 100;
    }

    public Hospital updatePercent(Long id, PercentRequest percentRequest) throws NotFoundException {
        Hospital hospital = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Errors.ML101.getMessage(), Errors.ML101.getCode()));
        hospital.setPercent(percentRequest.getPercent());
        return hospital;
    }

    public Hospital getOccupationSmaller() {
        return repository.findAll().stream()
                .filter(h -> h.getPercent() < 90)
                .min(Comparator.comparing(Hospital::getDateTime))
                .orElseThrow();
    }

    public Hospital getOccupationLarger() {
        return repository.findAll().stream()
                .filter(h -> h.getPercent() > 90)
                .min(Comparator.comparing(Hospital::getDateTime))
                .orElseThrow();
    }
}

