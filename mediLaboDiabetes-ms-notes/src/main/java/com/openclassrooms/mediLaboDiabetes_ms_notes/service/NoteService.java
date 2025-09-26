package com.openclassrooms.mediLaboDiabetes_ms_notes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.mediLaboDiabetes_ms_notes.model.Note;
import com.openclassrooms.mediLaboDiabetes_ms_notes.model.NoteDTO;
import com.openclassrooms.mediLaboDiabetes_ms_notes.repository.NoteRepository;

/**
 * NoteService is a class dedicated to handling Note Entities (get/add/update/delete)
 */
@Service
public class NoteService {
    @Autowired
    NoteRepository noteRepository;

    /**
     * Finds a single note
     * @param noteId id of the note
     * @return the note found
     */
    public Note getNoteById(String noteId) {
        return noteRepository.findById(noteId).get();
    }

    /**
     * Finds every note belonging to a patient
     * @param patientId id of the patient whose notes we look for
     * @return a list of the notes found
     */
    public List<Note> getNotesOfPatient(String patientId) {
        return noteRepository.findByPatientId(patientId);
    }

    /**
     * Transforms every note found into a DTO containing: [id, noteContent]
     * @param patientId the id of the patient whose notes we look for
     * @return a list of DTOs made from the notes of the patient
     */
    public List<NoteDTO> getNotesOfPatientDTO(String patientId) {
        List<NoteDTO> noteDTOList = new ArrayList<NoteDTO>();
        List<Note> noteList = noteRepository.findByPatientId(patientId);
        for (Note note : noteList)
            noteDTOList.add(new NoteDTO(note.getId(), note.getNoteContent()));

        return noteDTOList;
    }

    /**
     * Adds a single note
     * @param note the note to add
     * @return true if everything went right
     */
    public boolean addNote(Note note) {
        noteRepository.insert(note);
        return true;
    }

    /**
     * Updates a given note
     * @param note the note to modify
     * @return true if everything went right
     */
    public boolean updateNote(Note note) {
        noteRepository.save(note);
        return true;
    }
}
