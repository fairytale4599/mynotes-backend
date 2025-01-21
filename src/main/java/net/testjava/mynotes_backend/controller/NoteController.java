package net.testjava.mynotes_backend.controller;

import net.testjava.mynotes_backend.dto.NoteDto;
import net.testjava.mynotes_backend.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    // Create Note
    @PostMapping
    public ResponseEntity<NoteDto> createNote(@RequestBody NoteDto noteDto) {
        NoteDto savedNote = noteService.createNote(noteDto);
        return new ResponseEntity<>(savedNote, HttpStatus.CREATED);
    }

    // Get note by ID
    @GetMapping("{id}")
    public ResponseEntity<NoteDto> getNote(@PathVariable("id") long id) {
        NoteDto noteDto = noteService.getNote(id);
        return new ResponseEntity<>(noteDto, HttpStatus.OK);
    }

    // Get all notes
    @GetMapping
    public ResponseEntity<List<NoteDto>> getAllNotes() {
        List<NoteDto> noteDtos = noteService.getAllNotes();
        return new ResponseEntity<>(noteDtos, HttpStatus.OK);
    }

    // Delete note by ID
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteNote(@PathVariable("id") long id) {
        NoteDto noteDto = noteService.deleteNote(id);
        return ResponseEntity.ok("Note has been deleted.");
    }

    // Update note by ID
    @PutMapping("{id}")
    public ResponseEntity<String> updateNote(@PathVariable("id") Long id,
                                             @RequestBody NoteDto noteDto) {
        NoteDto updatedNote = noteService.updateNote(id, noteDto);
        return ResponseEntity.ok("Note has been updated.");
    }
}
