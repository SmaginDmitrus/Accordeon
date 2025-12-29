package com.git.smagindmitrus.accordeon.model;

import jakarta.persistence.*;

@Entity
public class ChordPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String chord;  // Например: "Am", "C", "G7"
    private int position;  // Позиция в тексте (индекс символа)
    private String lyricsFragment;  // Фрагмент текста под аккордом

    @ManyToOne
    @JoinColumn(name = "song_id")
    private Song song;
}
