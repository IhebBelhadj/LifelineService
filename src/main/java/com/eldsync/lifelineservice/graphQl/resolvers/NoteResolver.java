package com.eldsync.lifelineservice.graphQl.resolvers;

import com.eldsync.lifelineservice.DTOs.req.NoteInput;
import com.eldsync.lifelineservice.entities.Asset;
import com.eldsync.lifelineservice.entities.Note;
import com.eldsync.lifelineservice.services.AssetService;
import com.eldsync.lifelineservice.services.NoteService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class NoteResolver {

    private final NoteService noteService;
    private final AssetService assetService;

    public NoteResolver(NoteService noteService, AssetService assetService) {
        this.noteService = noteService;
        this.assetService = assetService;
    }

    @QueryMapping
    public Note getNoteWithId(@Argument Long noteId) {
        return noteService.getNoteWithId(noteId);
    }

    @MutationMapping
    public Note createNote(@Argument NoteInput noteData) {
        return noteService.createNote(noteData);
    }

    @MutationMapping
    public Note updateNote(@Argument Long noteId, @Argument NoteInput editedNoteData) {
        return noteService.updateNote(noteId, editedNoteData);
    }

    @MutationMapping
    public String deleteNote(@Argument Long noteId) {
        return noteService.deleteNote(noteId);
    }

    @SchemaMapping
    public List<Asset> assets(Note note) {
        // Fetch assets associated with the note using note ID
        List<Long> assetIds = note.getAssets().stream().map(Asset::getAssetId).toList();
        return assetIds.stream().map(assetService::getAssetWithId).toList();
    }
}