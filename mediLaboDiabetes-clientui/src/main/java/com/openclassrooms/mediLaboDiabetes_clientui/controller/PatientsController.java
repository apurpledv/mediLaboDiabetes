package com.openclassrooms.mediLaboDiabetes_clientui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.openclassrooms.mediLaboDiabetes_clientui.beans.NoteBeanDTO;
import com.openclassrooms.mediLaboDiabetes_clientui.beans.PatientBean;
import com.openclassrooms.mediLaboDiabetes_clientui.proxies.MSNoteProxy;
import com.openclassrooms.mediLaboDiabetes_clientui.proxies.MSPatientProxy;
import com.openclassrooms.mediLaboDiabetes_clientui.proxies.MSRiskProxy;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

/**
 * PatientsController is a class that handles FrontEnd for everything related to Patients (adding, updating or visualizing)
 */
@Slf4j
@Controller
public class PatientsController {
    @Autowired
    MSPatientProxy patientProxy;

    @Autowired
    MSNoteProxy notesProxy;

    @Autowired
    MSRiskProxy riskProxy;

    /**
     * Lists every patient found within the db
     * @param model
     * @return the "patients/patients-list" template
     */
    @GetMapping("/patients/{page}")
    public String patientsView(@PathVariable("page") int page, Model model) {
        List<PatientBean> patientsList = patientProxy.getPatients(page);
        model.addAttribute("patientsList", patientsList);
        model.addAttribute("prevPatPage", Math.max(0, page - 1));
        model.addAttribute("nextPatPage", page + 1);

        return "patients/patients-list";
    }

    /**
     * Displays a form to add a new patient
     * @param model
     * @return the "patients/patients-add" template
     */
    @GetMapping("/patients/add")
    public String patientsAddView(Model model) {
        model.addAttribute("addedPatient", new PatientBean());

        return "patients/patients-add";
    }

    /**
     * Executes the 'add a new patient' request
     * @param addedPatient the new patient to add
     * @param model
     * @return a redirection towards the list of patients page
     */
    @PostMapping("/patients/add")
    public String patientsAddPost(@ModelAttribute PatientBean addedPatient, Model model) {
        patientProxy.savePatient(addedPatient);

        return "redirect:/patients";
    }

    /**
     * Displays a form to update a given patient, as well as shows every note of a patient and their risk level
     * @param id id of the patient
     * @param model
     * @return the "patients/patients-infos" template
     */
    @GetMapping("/patients/infos/{id}")
    public String patientsUpdateView(@PathVariable int id, Model model) {
        PatientBean placeholderPatient = patientProxy.getPatient(id);
        model.addAttribute("placeholderPatient", placeholderPatient);
        model.addAttribute("updatedPatient", new PatientBean());

        try {
            List<NoteBeanDTO> notesList = notesProxy.getNotesOfPatient(String.valueOf(id));
            for (NoteBeanDTO note : notesList)
                note.setNoteContent(note.getNoteContent().replaceAll("\n", "<br>\n"));

            model.addAttribute("notesList", notesList);

            int riskLevel = riskProxy.getRiskLevel(id);
            String riskLevelTitle;
            switch(riskLevel) {
                case 0: riskLevelTitle = "Aucun danger"; break;
                case 1: riskLevelTitle = "Risque limité"; break;
                case 2: riskLevelTitle = "Danger"; break;
                case 3: riskLevelTitle = "Apparition précoce"; break;
                default: riskLevelTitle = "Aucun danger";
            }
            model.addAttribute("riskLevel", riskProxy.getRiskLevel(id));
            model.addAttribute("riskLevelTitle", riskLevelTitle);

        } catch (FeignException e) {
            model.addAttribute("notesList", null);
            model.addAttribute("notesErrorMsg", "Service de notes indisponible.");
            log.error(e.toString());
        }

        return "patients/patients-infos";
    }
    
    /**
     * Executes the 'update a patient's data' request
     * @param id id of the patient to modify
     * @param updatedPatient the new patient data
     * @param model
     * @return a redirection towards the list of patients
     */
    @PostMapping("/patients/update/{id}")
    public String patientsUpdatePost(@PathVariable int id, @ModelAttribute("updatedPatient") PatientBean updatedPatient, Model model) {
        patientProxy.updatePatient(id, updatedPatient);

        return "redirect:/patients";
    }
}
