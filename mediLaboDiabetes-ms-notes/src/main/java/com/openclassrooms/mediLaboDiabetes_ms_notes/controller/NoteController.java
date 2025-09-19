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

@RestController
public class NoteController {
    @Autowired
    NoteService noteService;

    @GetMapping("/note/getNotesOfPatient/{patientId}")
    public List<Note> getNotesOfPatient(@PathVariable String patientId) {
        return noteService.getNotesOfPatient(patientId);
    }

    @GetMapping("/note/getNotesOfPatientDTO/{patientId}")
    public List<NoteDTO> getNotesOfPatientDTO(@PathVariable String patientId) {
        return noteService.getNotesOfPatientDTO(patientId);
    }

    @GetMapping("/note/get/{id}")
    public Note get(@PathVariable String id) {
        return noteService.getNoteById(id);
    }

    @PostMapping("/note/add")
    public Boolean add(@RequestBody Note note) {
        return noteService.addNote(note);
    }

    @PostMapping("/note/update/{id}")
    public Boolean update(@PathVariable String id, @RequestBody Note note) {
        note.setId(id);
        return noteService.updateNote(note);
    }
}
