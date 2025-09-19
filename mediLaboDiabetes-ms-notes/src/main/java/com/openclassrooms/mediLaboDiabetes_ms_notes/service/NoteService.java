package com.openclassrooms.mediLaboDiabetes_ms_notes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.mediLaboDiabetes_ms_notes.model.Note;
import com.openclassrooms.mediLaboDiabetes_ms_notes.model.NoteDTO;
import com.openclassrooms.mediLaboDiabetes_ms_notes.repository.NoteRepository;

@Service
public class NoteService {
    @Autowired
    NoteRepository noteRepository;

    public Note getNoteById(String noteId) {
        return noteRepository.findById(noteId).get();
    }

    public List<Note> getNotesOfPatient(String patientId) {
        return noteRepository.findByPatientId(patientId);
    }

    public List<NoteDTO> getNotesOfPatientDTO(String patientId) {
        List<NoteDTO> noteDTOList = new ArrayList<NoteDTO>();
        List<Note> noteList = noteRepository.findByPatientId(patientId);
        for (Note note : noteList)
            noteDTOList.add(new NoteDTO(note.getId(), note.getNoteContent()));

        return noteDTOList;
    }

    public boolean addNote(Note note) {
        noteRepository.insert(note);
        return true;
    }

    public boolean updateNote(Note note) {
        noteRepository.save(note);
        return true;
    }
}
