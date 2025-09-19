package com.openclassrooms.mediLaboDiabetes_ms_notes;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.openclassrooms.mediLaboDiabetes_ms_notes.model.Note;
import com.openclassrooms.mediLaboDiabetes_ms_notes.repository.NoteRepository;

@SpringBootTest
class NoteRepositoryTests {
	@Autowired
	NoteRepository noteRepository;

	@Test
	void noteRepositoryTest() {
		// Read
		List<Note> noteList = noteRepository.findAll();
		assertTrue(!noteList.isEmpty());

		// Add
		Note note = new Note();
		note.setPatientLastName("testPatient99999");
		note = noteRepository.insert(note);
		final String noteId = note.getId();
		assertTrue(noteRepository.findById(note.getId()).get() instanceof Note);

		// Update
		note.setPatientLastName("testPatient99999Last");
		noteRepository.save(note);
		assertTrue(noteRepository.findById(noteId).get().getPatientLastName().equals("testPatient99999Last"));

		// Delete
		noteRepository.delete(note);
		assertThrows(NoSuchElementException.class, () -> noteRepository.findById(noteId).get());

		// Read All By Patient Id
		noteList = noteRepository.findByPatientId("1");
		System.out.println(noteList);
		assertTrue(!noteList.isEmpty());
	}

}
