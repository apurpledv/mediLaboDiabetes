package com.openclassrooms.mediLaboDiabetes_ms_patient.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name="t_patient")
public class Patient {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @NotBlank(message="firstName is required")
    @Column(name="firstname")
    String firstName;
    
    @NotBlank(message="lastName is required")
    @Column(name="lastname")
    String lastName;

    @NotBlank(message="birthDate is required")
    @Column(name="birthdate")
    String birthDate;
    
    @NotBlank(message="gender is required")
    String gender;
    
    String address;
    String phone;

    public Patient() {}

    public Patient(String firstName, String lastName, String birthDate, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }
}
