package com.git.smagindmitrus.accordeon.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;
import java.util.List;

@Entity
@Table(name = "songs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String artist;

    @Column(columnDefinition = "TEXT")
    private String lyrics;

    @Column(name = "chords_text")
    private String chordsText; // Аккорды в виде текста

    // Можно добавить больше полей: жанр, сложность, дата добавления и т.д.
}