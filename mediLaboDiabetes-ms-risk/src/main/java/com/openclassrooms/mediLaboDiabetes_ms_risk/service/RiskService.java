package com.openclassrooms.mediLaboDiabetes_ms_risk.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.openclassrooms.mediLaboDiabetes_ms_risk.model.NoteBeanDTO;
import com.openclassrooms.mediLaboDiabetes_ms_risk.model.PatientBean;
import com.openclassrooms.mediLaboDiabetes_ms_risk.model.RiskPatientDTO;
import com.openclassrooms.mediLaboDiabetes_ms_risk.model.RiskRuleSet;

@Service
public class RiskService {
    private int ageThreshold = 30;
    private List<RiskRuleSet> ruleSets = new ArrayList<>();
    private List<String> listSymptoms = new ArrayList<>();

    public RiskService() {
        setupRuleSets();
        setupSymptomsList();
    }

    /** 
     * Creates every RuleSets used to determine the Risk Level a Patient falls into. A RuleSet is a filter that, if respected, will dispense its 'RiskLevel'. A RuleSet has several parameters: a gender, a min/max age, and a min/max number of symptoms.
     */
    private void setupRuleSets() {
        ruleSets.add(new RiskRuleSet(0, "", -1, -1, -1, 2));

        ruleSets.add(new RiskRuleSet(1, "", ageThreshold, -1, 2, 6));

        ruleSets.add(new RiskRuleSet(2, "", ageThreshold, -1, 6, 8));
        ruleSets.add(new RiskRuleSet(2, "M", 0, ageThreshold, 3, 5));
        ruleSets.add(new RiskRuleSet(2, "F", 0, ageThreshold, 4, 7));

        ruleSets.add(new RiskRuleSet(3, "", ageThreshold, -1, 8, -1));
        ruleSets.add(new RiskRuleSet(3, "M", 0, ageThreshold, 5, -1));
        ruleSets.add(new RiskRuleSet(3, "F", 0, ageThreshold, 7, -1));
    }

    /**
     * Creates the list of every symptom to look for
     */
    private void setupSymptomsList() {
        listSymptoms = new ArrayList<>();
        listSymptoms.add("Hémoglobine A1C");
        listSymptoms.add("Microalbumine");
        listSymptoms.add("Taille");
        listSymptoms.add("Poids");
        listSymptoms.add("Fumeur");
        listSymptoms.add("Fumeuse");
        listSymptoms.add("Anormal");
        listSymptoms.add("Cholestérol");
        listSymptoms.add("Vertige");
        listSymptoms.add("Rechute");
        listSymptoms.add("Réaction");
        listSymptoms.add("Anticorps");
    }

    /**
     * Parses a patient's notes to find every unique occurrence of a symptom
     * @param listNotes The List containing every note's content
     * @return How many symptoms were found
     */
    public int getNumberOfSymptoms(List<String> listNotes) {
        Set<String> foundSymptoms = new HashSet<>();

        for (String note : listNotes) {
            for (String symptom : listSymptoms) {
                if (note.toLowerCase().contains(symptom.toLowerCase()))
                    foundSymptoms.add(symptom);
            }
        }

        return foundSymptoms.size();
    }

    /**
     * Using every ruleset defined earlier, tests each of them with the patient's data (number of symptoms found, their age and gender.)
     * @param numSymptoms Number of symptoms detected
     * @param age Age of the patient
     * @param gender Gender of the patient
     * @return The Risk Level (0-3) if at least one RuleSet is valid, -1 otherwise
     */
    public int getRiskLevel(int numSymptoms, int age, String gender) {
        int riskLevel = -1;
        for (RiskRuleSet ruleSet : ruleSets) {
            if (!ruleSet.testRules(numSymptoms, age, gender))
                continue;

            riskLevel = ruleSet.getRiskLevel();
            break;
        }

        return riskLevel;
    }

    public RiskPatientDTO createRiskPatientDTO(PatientBean patient, List<NoteBeanDTO> notesDTO) {
        int id = patient.getId();
        int age = Period.between(
            LocalDate.parse(patient.getBirthDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")), 
            LocalDate.now()
        ).getYears();
        String gender = patient.getGender();

        List<String> noteStrings = new ArrayList<>();
        for (NoteBeanDTO note : notesDTO)
            noteStrings.add(note.getNoteContent());

        return new RiskPatientDTO(id, age, gender, noteStrings);
    }
    
}
