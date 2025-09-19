package com.openclassrooms.mediLaboDiabetes_ms_patient;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.openclassrooms.mediLaboDiabetes_ms_patient.model.Patient;
import com.openclassrooms.mediLaboDiabetes_ms_patient.repository.PatientRepository;
import com.openclassrooms.mediLaboDiabetes_ms_patient.service.PatientService;

@SpringBootTest
public class PatientServiceTests {
    @Autowired
    PatientService patientService;

    @MockitoBean
    PatientRepository patientRepo;

    @Test
    void testPatientService() {
        Patient patient = new Patient("testPatient", "", "", "");

        // Add
        assertTrue(patientService.savePatient(patient));

        // Update
        patient.setFirstName("testPatient2");
        assertTrue(patientService.savePatient(patient));

        // Delete
        assertTrue(patientService.deletePatient(patient));
    }
}
