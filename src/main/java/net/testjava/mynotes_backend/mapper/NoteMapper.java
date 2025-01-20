package net.testjava.mynotes_backend.mapper;

import net.testjava.mynotes_backend.dto.NoteDto;
import net.testjava.mynotes_backend.entity.Note;

public class NoteMapper {

    public static NoteDto mapToNoteDto(Note note) {
        if (note == null) {
            throw new IllegalArgumentException("Note object cannot be null");
        }

        return new NoteDto(note.getId(),
                note.getNote_title(),
                note.getNote_text(),
                note.getCreated_at());
    }

    public static Note mapToNote(NoteDto noteDto) {
        Note note = new Note(
                noteDto.getId(),
                noteDto.getNote_title(),
                noteDto.getNote_text(),
                noteDto.getCreated_at()
        );
        return note;
    }
}
