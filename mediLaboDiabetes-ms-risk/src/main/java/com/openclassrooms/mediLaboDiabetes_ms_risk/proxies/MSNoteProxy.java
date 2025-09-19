package com.openclassrooms.mediLaboDiabetes_ms_risk.proxies;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.openclassrooms.mediLaboDiabetes_ms_risk.model.NoteBeanDTO;

@FeignClient(name="mediLaboDiabetes-api-gateway", contextId="ms-notes2")
@RibbonClient(name="mediLaboDiabetes-ms-notes")
public interface MSNoteProxy {
    @GetMapping("/medilabodiabetes-ms-notes/note/getNotesOfPatientDTO/{patientId}")
    List<NoteBeanDTO> getNotesOfPatient(@PathVariable String patientId);
}
