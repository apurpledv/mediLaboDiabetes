package com.openclassrooms.mediLaboDiabetes_ms_patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.mediLaboDiabetes_ms_patient.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    public Patient findByFirstName(String firstName);
}
