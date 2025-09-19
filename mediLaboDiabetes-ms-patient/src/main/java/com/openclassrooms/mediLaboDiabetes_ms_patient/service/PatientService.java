package com.openclassrooms.mediLaboDiabetes_ms_patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.mediLaboDiabetes_ms_patient.model.Patient;
import com.openclassrooms.mediLaboDiabetes_ms_patient.repository.PatientRepository;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepo;

    public List<Patient> getPatients() {
        return patientRepo.findAll();
    }

    public Patient getPatientById(int id) {
        return patientRepo.findById(id).get();
    }

    public Boolean savePatient(Patient patient) {
        patientRepo.save(patient);
        return true;
    }

    public Boolean updatePatient(Patient patient) {
        Patient oldPatient = patientRepo.findById(patient.getId()).get();
        if (patient.getLastName() != null && !patient.getLastName().isBlank()) 
            oldPatient.setLastName(patient.getLastName());

        if (patient.getFirstName() != null && !patient.getFirstName().isBlank()) 
            oldPatient.setFirstName(patient.getFirstName());

        if (patient.getGender() != null && !patient.getGender().isBlank()) 
            oldPatient.setGender(patient.getGender());

        if (patient.getBirthDate() != null && !patient.getBirthDate().isBlank()) 
            oldPatient.setBirthDate(patient.getBirthDate());

        if (patient.getAddress() != null && !patient.getAddress().isBlank())
            oldPatient.setAddress(patient.getAddress());

        if (patient.getPhone() != null && !patient.getPhone().isBlank()) 
            oldPatient.setPhone(patient.getPhone());

        patientRepo.save(oldPatient);
        return true;
    }

    public Boolean deletePatient(Patient patient) {
        patientRepo.delete(patient);
        return true;
    }
}
