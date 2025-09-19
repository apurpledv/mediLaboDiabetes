package com.openclassrooms.mediLaboDiabetes_ms_risk.model;

import lombok.Data;

@Data
public class NoteBeanDTO {
    String id;
    String noteContent;

    public NoteBeanDTO() {}

    public NoteBeanDTO(String id, String noteContent) {
        this.id = id;
        this.noteContent = noteContent;
    }
}
