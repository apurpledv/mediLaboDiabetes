package com.openclassrooms.mediLaboDiabetes_ms_notes.model;

import lombok.Data;

@Data
public class NoteDTO {
    String id;
    String noteContent;

    public NoteDTO() {

    }

    public NoteDTO(String id, String noteContent) {
        this.id = id;
        this.noteContent = noteContent;
    }
}
