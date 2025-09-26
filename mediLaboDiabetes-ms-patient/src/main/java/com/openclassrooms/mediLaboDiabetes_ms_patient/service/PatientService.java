package com.openclassrooms.mediLaboDiabetes_ms_patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.openclassrooms.mediLaboDiabetes_ms_patient.model.Patient;
import com.openclassrooms.mediLaboDiabetes_ms_patient.repository.PatientRepository;

/**
 * PatientService is a class dedicated to handling Patient Entities (get/add/update/delete)
 */
@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepo;

    /**
     * Returns a list of every patient registered in the db
     * @return a list of Patients
     */
    public List<Patient> getPatients() {
        return patientRepo.findAll();
    }

    public Page<Patient> getPatientsPage(int pageNumber, int paitentPerPage) {
        return patientRepo.findAll(PageRequest.of(pageNumber, paitentPerPage, Sort.by("lastName")));
    }

    /**
     * Returns one given patient
     * @param id id of the patient to find
     * @return the Patient
     */
    public Patient getPatientById(int id) {
        return patientRepo.findById(id).get();
    }

    /**
     * Adds a new patient
     * @param patient the new patient to add
     * @return true if everything went right
     */
    public Boolean savePatient(Patient patient) {
        patientRepo.save(patient);
        return true;
    }

    /**
     * Updates a given patient, depending on if fields are updated (new data's field isn't null or blank)
     * @param patient the new patient data
     * @return true if everything went right
     */
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
