package com.openclassrooms.mediLaboDiabetes_ms_risk.proxies;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.openclassrooms.mediLaboDiabetes_ms_risk.model.PatientBean;

@FeignClient(name="mediLaboDiabetes-api-gateway", contextId="ms-patient2")
@RibbonClient(name="mediLaboDiabetes-ms-patient")
public interface MSPatientProxy {
    @GetMapping("/medilabodiabetes-ms-patient/patient/get/{id}")
    PatientBean getPatient(@PathVariable int id);
}
