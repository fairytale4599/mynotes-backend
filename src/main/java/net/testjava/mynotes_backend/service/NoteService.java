package net.testjava.mynotes_backend.service;

import net.testjava.mynotes_backend.dto.NoteDto;

import java.util.List;

public interface NoteService {
    NoteDto createNote(NoteDto note);
    NoteDto getNote(Long id);
    List<NoteDto> getAllNotes();
    NoteDto deleteNote(Long id);
    NoteDto updateNote(Long id, NoteDto note);
}
