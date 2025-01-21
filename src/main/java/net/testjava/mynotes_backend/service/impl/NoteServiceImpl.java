package net.testjava.mynotes_backend.service.impl;

import net.testjava.mynotes_backend.dto.NoteDto;
import net.testjava.mynotes_backend.entity.Note;
import net.testjava.mynotes_backend.exception.ResourceNotFoundException;
import net.testjava.mynotes_backend.mapper.NoteMapper;
import net.testjava.mynotes_backend.repository.NoteRepository;
import net.testjava.mynotes_backend.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public NoteDto getNote(Long id) {
        Note notee = noteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found"));
        System.out.println("Note: " + notee);
        return NoteMapper.mapToNoteDto(notee);
    }

    @Override
    public List<NoteDto> getAllNotes() {
        List<Note> notees = noteRepository.findAll();
        return notees.stream().map((note -> NoteMapper.mapToNoteDto(note))).collect(Collectors.toList());
    }

    @Override
    public NoteDto deleteNote(Long id) {
        Note notee = noteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found"));
        noteRepository.delete(notee);
        return NoteMapper.mapToNoteDto(notee);
    }

    @Override
    public NoteDto updateNote(Long id, NoteDto noteDto) {
        Note notee = noteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found"));
        notee.setNote_title(noteDto.getNote_title());
        notee.setNote_text(noteDto.getNote_text());
        notee.setCreated_at(noteDto.getCreated_at());

        Note updatedNote = noteRepository.save(notee);
        return NoteMapper.mapToNoteDto(updatedNote);
    }
}
