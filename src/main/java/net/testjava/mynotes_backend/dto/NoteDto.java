package net.testjava.mynotes_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteDto {

    private Long id;
    private String note_title;
    private String note_text;
    private LocalDateTime created_at;

    public Long getId() {
        return id;
    }

    public String getNote_title() {
        return note_title;
    }

    public String getNote_text() {
        return note_text;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public NoteDto(Long id, String note_title, String note_text, LocalDateTime created_at) {
        this.id = id;
        this.note_title = note_title;
        this.note_text = note_text;
        this.created_at = created_at;
    }
}
