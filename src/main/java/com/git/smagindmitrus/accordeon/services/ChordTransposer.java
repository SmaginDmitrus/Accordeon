package com.git.smagindmitrus.accordeon.services;

import org.springframework.stereotype.Component;

@Component
public class ChordTransposer {

    private static final String[] CHORDS = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

    public String transpose(String chordsText, int semitones) {
        if (chordsText == null || chordsText.trim().isEmpty()) {
            return chordsText;
        }

        String[] chords = chordsText.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String chord : chords) {
            result.append(transposeChord(chord, semitones)).append(" ");
        }

        return result.toString().trim();
    }

    private String transposeChord(String chord, int semitones) {
        // Базовая реализация - потом можно улучшить
        int index = findChordIndex(chord);
        if (index == -1) return chord;

        int newIndex = (index + semitones) % CHORDS.length;
        if (newIndex < 0) newIndex += CHORDS.length;

        return CHORDS[newIndex];
    }

    private int findChordIndex(String chord) {
        for (int i = 0; i < CHORDS.length; i++) {
            if (CHORDS[i].equals(chord.replace("m", "").replace("7", ""))) {
                return i;
            }
        }
        return -1;
    }
}