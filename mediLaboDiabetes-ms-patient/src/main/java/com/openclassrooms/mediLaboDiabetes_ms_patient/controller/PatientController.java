package com.openclassrooms.mediLaboDiabetes_ms_patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.mediLaboDiabetes_ms_patient.model.Patient;
import com.openclassrooms.mediLaboDiabetes_ms_patient.service.PatientService;

/**
 * PatientController is a class that handles HTTP requests aimed at interacting with Patient Entities
 */
@RestController
public class PatientController {
    @Autowired
    PatientService patientService;

    int numPatientsPerPage = 3;

    /**
     * Lists every patient registered in the app
     * @return a list of patients
     */
    @GetMapping("/patient/getAll/{page}")
    public List<Patient> getPatients(@PathVariable("page") int page) {
        return new PagedModel<>(patientService.getPatientsPage(page, numPatientsPerPage)).getContent();
    }

    /**
     * Returns a single patient
     * @param id id of the patient
     * @return the patient entity found
     */
    @GetMapping("/patient/get/{id}")
    public Patient get(@PathVariable int id) {
        return patientService.getPatientById(id);
    }

    /**
     * Adds a patient
     * @param patient the Patient Entity to add
     * @return true if everything went right
     */
    @PostMapping("/patient/add")
    public Boolean add(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    /**
     * Updates a given patient
     * @param id id of the patient to modify
     * @param patient the new patient data
     * @return true if everything went right
     */
    @PostMapping("/patient/update/{id}")
    public Boolean update(@PathVariable int id, @RequestBody Patient patient) {
        patient.setId(id);
        return patientService.updatePatient(patient);
    }

    /**
     * Deletes a given patient
     * @param id id of the patient to delete
     * @return true if everything went right
     */
    @DeleteMapping("/patient/delete/{id}")
    public Boolean delete(@PathVariable int id) {
        return patientService.deletePatient(patientService.getPatientById(id));
    }
}
