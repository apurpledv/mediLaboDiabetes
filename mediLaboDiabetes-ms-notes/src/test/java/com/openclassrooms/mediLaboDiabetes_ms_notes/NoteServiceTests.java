package com.openclassrooms.mediLaboDiabetes_ms_notes;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.openclassrooms.mediLaboDiabetes_ms_notes.model.Note;
import com.openclassrooms.mediLaboDiabetes_ms_notes.repository.NoteRepository;
import com.openclassrooms.mediLaboDiabetes_ms_notes.service.NoteService;

@SpringBootTest
class NoteServiceTests {
	@Autowired
	NoteService noteService;

    @MockitoBean
    NoteRepository noteRepository;

	@Test
	void noteServiceTest() {
		// Read
        List<Note> dummyList = new ArrayList<Note>();
        dummyList.add(new Note());
        when(noteRepository.findAll()).thenReturn(dummyList);
        when(noteRepository.findByPatientId(anyString())).thenReturn(dummyList);

		List<Note> noteList = noteService.getNotesOfPatient("1");
		assertTrue(!noteList.isEmpty());

		// Add
		Note note = new Note();
		assertTrue(noteService.addNote(note));

		// Update
		assertTrue(noteService.updateNote(note));

		// Read All By Patient Id
		noteList = noteService.getNotesOfPatient("1");
		assertTrue(!noteList.isEmpty());
	}

}
