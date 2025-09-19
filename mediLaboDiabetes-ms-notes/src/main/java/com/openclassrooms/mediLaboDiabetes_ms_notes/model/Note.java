package com.openclassrooms.mediLaboDiabetes_ms_notes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "notes")
public class Note {
    @Id
    String id;
    String patientId;
    String patientLastName;
    String noteContent;
}
