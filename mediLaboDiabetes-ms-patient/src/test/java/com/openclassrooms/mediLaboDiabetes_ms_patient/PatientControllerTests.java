package com.openclassrooms.mediLaboDiabetes_ms_patient;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.openclassrooms.mediLaboDiabetes_ms_patient.controller.PatientController;
import com.openclassrooms.mediLaboDiabetes_ms_patient.model.Patient;
import com.openclassrooms.mediLaboDiabetes_ms_patient.service.PatientService;

@SpringBootTest
@AutoConfigureMockMvc
public class PatientControllerTests {
    @Autowired
	private MockMvc mockMvc;

    @Autowired
    PatientController patientController;

    @MockitoBean
    PatientService patientService;

    @Test
    void testPatientService() throws Exception {
        Patient patient = new Patient("testPatient", "", "", "");
        when(patientService.getPatientById(anyInt())).thenReturn(patient);
        
        // Get
        this.mockMvc.perform(get("/patient/get/1"))
            .andExpect(status().isOk());

        // Add
        this.mockMvc.perform(post("/patient/add")
            .content("{\"firstName\": \"testPatient\"}")
            .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        // Update
        this.mockMvc.perform(put("/patient/update/1")
            .content("{\"firstName\": \"testPatient\"}")
            .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        // Delete
        this.mockMvc.perform(delete("/patient/delete/1"))
            .andExpect(status().isOk());
    }
}
