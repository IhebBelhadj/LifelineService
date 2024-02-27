package com.eldsync.lifelineservice.services;

import com.eldsync.lifelineservice.DTOs.req.NoteInput;
import com.eldsync.lifelineservice.entities.Note;

public interface NoteService {
    Note getNoteWithId(Long noteId);
    Note createNote(NoteInput noteData);
    Note updateNote(Long noteId, NoteInput editedNoteData);
    String deleteNote(Long noteId);
}
