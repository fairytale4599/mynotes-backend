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
    private long id;

    @Column(name = "note_title", unique = true, nullable = false)
    private String note_title;

    @Column(name = "note_text")
    private String note_text;

    @Column(name = "created_at")
    private LocalDateTime created_at;
}
