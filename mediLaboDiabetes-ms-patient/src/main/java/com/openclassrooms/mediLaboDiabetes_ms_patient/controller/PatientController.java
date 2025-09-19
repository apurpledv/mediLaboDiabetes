package com.openclassrooms.mediLaboDiabetes_ms_patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.mediLaboDiabetes_ms_patient.model.Patient;
import com.openclassrooms.mediLaboDiabetes_ms_patient.service.PatientService;

@RestController
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("/patient/getAll")
    public List<Patient> getPatients() {
        return patientService.getPatients();
    }

    @GetMapping("/patient/get/{id}")
    public Patient get(@PathVariable int id) {
        return patientService.getPatientById(id);
    }

    @PostMapping("/patient/add")
    public Boolean add(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @PostMapping("/patient/update/{id}")
    public Boolean update(@PathVariable int id, @RequestBody Patient patient) {
        patient.setId(id);
        return patientService.updatePatient(patient);
    }

    @DeleteMapping("/patient/delete/{id}")
    public Boolean delete(@PathVariable int id) {
        return patientService.deletePatient(patientService.getPatientById(id));
    }
}
