package com.openclassrooms.mediLaboDiabetes_clientui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.openclassrooms.mediLaboDiabetes_clientui.beans.NoteBean;
import com.openclassrooms.mediLaboDiabetes_clientui.beans.PatientBean;
import com.openclassrooms.mediLaboDiabetes_clientui.proxies.MSNoteProxy;
import com.openclassrooms.mediLaboDiabetes_clientui.proxies.MSPatientProxy;

/**
 * NotesController is a class that handles the FrontEnd for everything related to Notes (adding or updating)
 */
@Controller
public class NotesController {
    @Autowired
    MSPatientProxy patientProxy;

    @Autowired
    MSNoteProxy notesProxy;

    /**
     * Displays a form to add a new Note
     * @param id id of the patient to add the note for
     * @param model
     * @return the "notes/notes-add" template
     */
    @GetMapping("/notes/add/{id}")
    public String notesAddView(@PathVariable String id, Model model) {
        model.addAttribute("patientId", id);
        model.addAttribute("addedNote", new NoteBean());

        return "notes/notes-add";
    }

    /**
     * Executes the 'add a new Note' request
     * @param patientId id of the patient this new note is for
     * @param addedNote the new note
     * @param model 
     * @return a redirection towards the patient's info page
     */
    @PostMapping("/notes/add/{patientId}")
    public String notesAddPost(@PathVariable String patientId, @ModelAttribute NoteBean addedNote, Model model) {
        PatientBean patient = patientProxy.getPatient(Integer.valueOf(patientId));
        addedNote.setPatientId(patientId);
        addedNote.setPatientLastName(patient.getLastName());

        notesProxy.addNote(addedNote);

        return "redirect:/patients/infos/" + patientId;
    }

    /**
     * Displays a form to update a given note
     * @param noteId the id of the note to update (used for a placeholder)
     * @param model
     * @return the "notes/notes-update" template
     */
    @GetMapping("/notes/update/{noteId}")
    public String notesUpdateView(@PathVariable String noteId, Model model) {
        NoteBean placeholderNote = notesProxy.getNote(noteId);
        model.addAttribute("placeholderNote", placeholderNote);
        model.addAttribute("updatedNote", new NoteBean());

        return "notes/notes-update";
    }

    /**
     * Executes the 'update a given note' request
     * @param noteId id of the note to modify
     * @param updatedNote the new note data
     * @param model
     * @return a redirection towards the patient's info page
     */
    @PostMapping("/notes/update/{noteId}")
    public String notesUpdatePost(@PathVariable String noteId, @ModelAttribute NoteBean updatedNote, Model model) {
        NoteBean oldNote = notesProxy.getNote(noteId);
        updatedNote.setId(noteId);
        updatedNote.setPatientId(oldNote.getPatientId());
        updatedNote.setPatientLastName(oldNote.getPatientLastName());
        notesProxy.updateNote(noteId, updatedNote);

        return "redirect:/patients/infos/" + updatedNote.getPatientId();
    }
}
