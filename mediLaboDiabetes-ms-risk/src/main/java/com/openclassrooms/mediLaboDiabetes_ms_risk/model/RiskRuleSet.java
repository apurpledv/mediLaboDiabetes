package com.openclassrooms.mediLaboDiabetes_ms_risk.model;

import lombok.Data;

@Data
public class RiskRuleSet {
    int riskLevel;
    String gender;
    int ageMin;
    int ageMax;
    int symptomsMin;
    int symptomsMax;

    public RiskRuleSet() {

    }

    public RiskRuleSet(int riskLevel, String gender, int ageMin, int ageMax, int symptomsMin, int symptomsMax) {
        this.riskLevel = riskLevel;
        this.ageMin = ageMin;
        this.ageMax = ageMax;
        this.symptomsMin = symptomsMin;
        this.symptomsMax = symptomsMax;
        this.gender = gender;
    }

    public boolean testRules(int numSymptoms, int age, String gender) {
        return (
            (this.symptomsMin == -1 || (this.symptomsMin != -1 && numSymptoms >= this.symptomsMin)) &&
            (this.symptomsMax == -1 || (this.symptomsMax != -1 && numSymptoms < this.symptomsMax)) &&
            (this.ageMin == -1 || (this.ageMin != -1 && age >= this.ageMin)) &&
            (this.ageMax == -1 || (this.ageMax != -1 && age < this.ageMax)) &&
            (this.gender.isBlank() || (!this.gender.isBlank() && gender.equals(this.gender)))
        );
    }
}
