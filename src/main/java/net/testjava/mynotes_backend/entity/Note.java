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
    private Long id; // Use wrapper class Long for consistency with DTO

    @Column(name = "note_title", unique = true, nullable = false)
    private String note_title;

    @Column(name = "note_text")
    private String note_text;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    public Long getId() {
        return id;
    }

    // Method to get Note Title
    public String getNote_title() {
        return note_title;
    }

    // Method to get Note Text
    public String getNote_text() {
        return note_text;
    }

    // Method to get Created At
    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public Note(Long id, String note_title, String note_text, LocalDateTime created_at) {
        this.id = id;
        this.note_title = note_title;
        this.note_text = note_text;
        this.created_at = created_at;
    }
}
