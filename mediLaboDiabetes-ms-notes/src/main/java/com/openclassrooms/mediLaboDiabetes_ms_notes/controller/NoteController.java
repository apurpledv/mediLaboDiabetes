package com.openclassrooms.mediLaboDiabetes_ms_notes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.mediLaboDiabetes_ms_notes.model.Note;
import com.openclassrooms.mediLaboDiabetes_ms_notes.model.NoteDTO;
import com.openclassrooms.mediLaboDiabetes_ms_notes.service.NoteService;

/**
 * NoteController is a class that handles HTTP Requests aimed at interacting with Note Entities
 */
@RestController
public class NoteController {
    @Autowired
    NoteService noteService;

    /**
     * Finds every note belonging to a patient
     * @param patientId the id of the patient whose notes we look for
     * @return a list of Notes
     */
    @GetMapping("/note/getNotesOfPatient/{patientId}")
    public List<Note> getNotesOfPatient(@PathVariable String patientId) {
        return noteService.getNotesOfPatient(patientId);
    }

    /**
     * Returns every note belonging to a patient in a DTO format - [id, noteContent]
     * @param patientId the id of the patient whose notes we look for
     * @return a list of Note DTOs
     */
    @GetMapping("/note/getNotesOfPatientDTO/{patientId}")
    public List<NoteDTO> getNotesOfPatientDTO(@PathVariable String patientId) {
        return noteService.getNotesOfPatientDTO(patientId);
    }

    /**
     * Finds a single note via its id
     * @param id id of the note to look for
     * @return a Note
     */
    @GetMapping("/note/get/{id}")
    public Note get(@PathVariable String id) {
        return noteService.getNoteById(id);
    }

    /**
     * Adds a single note
     * @param note the note to add
     * @return true if everything went right
     */
    @PostMapping("/note/add")
    public Boolean add(@RequestBody Note note) {
        return noteService.addNote(note);
    }

    /**
     * Updates a given note
     * @param id id of the note to modify
     * @param note the new note data
     * @return true if everything went right
     */
    @PostMapping("/note/update/{id}")
    public Boolean update(@PathVariable String id, @RequestBody Note note) {
        note.setId(id);
        return noteService.updateNote(note);
    }
}
