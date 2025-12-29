package com.git.smagindmitrus.accordeon.controller;

import com.git.smagindmitrus.accordeon.model.Song;
import com.git.smagindmitrus.accordeon.services.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @PostMapping
    public ResponseEntity<Song> addSong(@RequestBody Song song) {
        Song savedSong = songService.save(song);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSong);
    }

    @GetMapping
    public ResponseEntity<List<Song>> getAllSongs() {
        return ResponseEntity.ok(songService.getAllSongs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSong(@PathVariable Long id) {
        return ResponseEntity.ok(songService.getSongById(id));
    }

    @GetMapping("/artist/{artist}")
    public ResponseEntity<List<Song>> getSongsByArtist(@PathVariable String artist) {
        return ResponseEntity.ok(songService.getSongsByArtist(artist));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Song>> searchSongs(@RequestParam String title) {
        return ResponseEntity.ok(songService.searchSongsByTitle(title));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Song> updateSong(@PathVariable Long id, @RequestBody Song song) {
        return ResponseEntity.ok(songService.updateSong(id, song));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable Long id) {
        songService.deleteSong(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getSongCount() {
        return ResponseEntity.ok(songService.getSongCount());
    }

    @GetMapping("/status")
    public String greet() {
        return "AccordeON works! Songs in DB: " + songService.getSongCount();
    }
}