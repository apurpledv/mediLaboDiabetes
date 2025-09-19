package com.openclassrooms.mediLaboDiabetes_ms_patient;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.openclassrooms.mediLaboDiabetes_ms_patient.model.Patient;
import com.openclassrooms.mediLaboDiabetes_ms_patient.repository.PatientRepository;

@SpringBootTest
public class PatientRepositoryTests {
    @Autowired
    PatientRepository patientRepo;

    @Test
    void testPatientRepo() {
        Patient patient = new Patient("testPatient", "", "", "");
        
        // Add
        patientRepo.save(patient);
        assertTrue(patientRepo.findByFirstName("testPatient") instanceof Patient);

        // Update
        patient.setFirstName("testPatient2");
        patientRepo.save(patient);
        assertTrue(patientRepo.findByFirstName("testPatient2") instanceof Patient);

        // Delete
        patientRepo.delete(patient);
        assertTrue(patientRepo.findByFirstName("testPatient2") == null);
    }
}
