package net.testjava.mynotes_backend.service;

import net.testjava.mynotes_backend.dto.NoteDto;

public interface NoteService {
    NoteDto createNote(NoteDto note);
}
