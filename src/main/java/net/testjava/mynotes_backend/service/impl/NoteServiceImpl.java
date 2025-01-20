package net.testjava.mynotes_backend.service.impl;

import net.testjava.mynotes_backend.dto.NoteDto;
import net.testjava.mynotes_backend.entity.Note;
import net.testjava.mynotes_backend.mapper.NoteMapper;
import net.testjava.mynotes_backend.repository.NoteRepository;
import net.testjava.mynotes_backend.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public NoteDto createNote(NoteDto noteDto) {
        Note notee = NoteMapper.mapToNote(noteDto);
        System.out.println("Before saving: " + notee);
        Note savedNote = noteRepository.save(notee);
        System.out.println("After saving: " + savedNote);

        if (savedNote == null) {
            throw new IllegalStateException("Failed to save note");
        }

        return NoteMapper.mapToNoteDto(savedNote);
    }

}
