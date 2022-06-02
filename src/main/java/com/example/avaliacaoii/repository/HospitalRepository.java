package com.example.avaliacaoii.repository;

import com.example.avaliacaoii.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
