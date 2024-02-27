package com.eldsync.lifelineservice.services.impl;


import com.eldsync.lifelineservice.DTOs.req.NoteInput;
import com.eldsync.lifelineservice.entities.Note;
import com.eldsync.lifelineservice.repositories.NoteRepository;
import com.eldsync.lifelineservice.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note getNoteWithId(Long noteId) {
        Optional<Note> optionalNote = noteRepository.findById(noteId);
        return optionalNote.orElse(null);
    }

    @Override
    public Note createNote(NoteInput noteData) {
        Note note = new Note();
        note.setNoteMarkdown(noteData.getNoteMarkdown());
        note.setReminderTime(noteData.getReminderTime());
        // Assuming assets are created before and their IDs are provided in noteData
        // You may need to load assets from repository based on provided IDs and set them here
        return noteRepository.save(note);
    }

    @Override
    public Note updateNote(Long noteId, NoteInput editedNoteData) {
        Optional<Note> optionalNote = noteRepository.findById(noteId);
        if (optionalNote.isPresent()) {
            Note note = optionalNote.get();
            note.setNoteMarkdown(editedNoteData.getNoteMarkdown());
            note.setReminderTime(editedNoteData.getReminderTime());
            // Update other fields as needed
            return noteRepository.save(note);
        } else {
            // Handle case where note with given ID is not found
            return null;
        }
    }

    @Override
    public String deleteNote(Long noteId) {
        Optional<Note> optionalNote = noteRepository.findById(noteId);
        if (optionalNote.isPresent()) {
            noteRepository.deleteById(noteId);
            return "Note with ID " + noteId + " deleted successfully";
        } else {
            return "Note with ID " + noteId + " not found";
        }
    }
}