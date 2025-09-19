package com.openclassrooms.mediLaboDiabetes_ms_risk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.mediLaboDiabetes_ms_risk.model.RiskPatientDTO;
import com.openclassrooms.mediLaboDiabetes_ms_risk.proxies.MSNoteProxy;
import com.openclassrooms.mediLaboDiabetes_ms_risk.proxies.MSPatientProxy;
import com.openclassrooms.mediLaboDiabetes_ms_risk.service.RiskService;

@RestController
public class RiskController {
    @Autowired
    RiskService riskService;

    @Autowired
    MSPatientProxy patientProxy;

    @Autowired
    MSNoteProxy noteProxy;

    @GetMapping("/riskLevel/get/{id}")
    public int getRiskLevel(@PathVariable int id) {
        RiskPatientDTO riskPatient = riskService.createRiskPatientDTO(
            patientProxy.getPatient(id), noteProxy.getNotesOfPatient(String.valueOf(id))
        );

        return riskService.getRiskLevel(
            riskService.getNumberOfSymptoms(riskPatient.getNotes()), 
            riskPatient.getAge(), 
            riskPatient.getGender()
        );
    }
}
