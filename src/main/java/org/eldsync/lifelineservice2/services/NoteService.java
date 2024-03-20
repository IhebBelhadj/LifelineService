package org.eldsync.lifelineservice2.services;


import org.eldsync.lifelineservice2.DTOs.req.NoteInput;
import org.eldsync.lifelineservice2.entities.Note;

public interface NoteService {
    Note getNoteWithId(Long noteId);
    Note createNote(NoteInput noteData);
    Note updateNote(Long noteId, NoteInput editedNoteData);
    String deleteNote(Long noteId);
}
