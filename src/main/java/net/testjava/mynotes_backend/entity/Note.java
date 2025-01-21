package net.testjava.mynotes_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "note_title", unique = true, nullable = false)
    private String note_title;

    @Column(name = "note_text")
    private String note_text;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    public Note() {
    }

    public Note(Long id, String note_title, String note_text, LocalDateTime created_at) {
        this.id = id;
        this.note_title = note_title;
        this.note_text = note_text;
        this.created_at = created_at;
    }

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

    public void setNote_title(String note_title) {
        this.note_title = note_title;
    }

    public void setNote_text(String note_text) {
        this.note_text = note_text;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
