package com.openclassrooms.mediLaboDiabetes_ms_risk.model;

import java.util.List;

import lombok.Data;

@Data
public class RiskPatientDTO {
    int id;
    int age;
    String gender;
    List<String> notes;

    public RiskPatientDTO() {}

    public RiskPatientDTO(int id, int age, String gender, List<String> notes) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.notes = notes;
    }
}
