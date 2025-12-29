package com.git.smagindmitrus.accordeon.services;

import com.git.smagindmitrus.accordeon.model.Song;
import com.git.smagindmitrus.accordeon.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SongService {

    private final SongRepository songRepository;

    /**
     * Сохранить песню в базу данных
     */
    public Song save(Song song) {
        log.info("Сохранение песни: {} - {}", song.getArtist(), song.getTitle());
        return songRepository.save(song);
    }

    /**
     * Получить все песни
     */
    public List<Song> getAllSongs() {
        log.info("Получение всех песен");
        return songRepository.findAll();
    }

    /**
     * Найти песню по ID
     */
    public Song getSongById(Long id) {
        log.info("Поиск песни по ID: {}", id);
        return songRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Песня с ID " + id + " не найдена"));
    }

    /**
     * Найти песни по исполнителю
     */
    public List<Song> getSongsByArtist(String artist) {
        log.info("Поиск песен исполнителя: {}", artist);
        return songRepository.findByArtist(artist);
    }

    /**
     * Поиск песен по названию (регистронезависимый)
     */
    public List<Song> searchSongsByTitle(String title) {
        log.info("Поиск песен по названию: {}", title);
        return songRepository.findByTitleContainingIgnoreCase(title);
    }

    /**
     * Удалить песню
     */
    public void deleteSong(Long id) {
        log.info("Удаление песни с ID: {}", id);
        songRepository.deleteById(id);
    }

    /**
     * Обновить песню
     */
    public Song updateSong(Long id, Song updatedSong) {
        log.info("Обновление песни с ID: {}", id);
        Song existingSong = getSongById(id);

        existingSong.setTitle(updatedSong.getTitle());
        existingSong.setArtist(updatedSong.getArtist());
        existingSong.setLyrics(updatedSong.getLyrics());
        existingSong.setChordsText(updatedSong.getChordsText());

        return songRepository.save(existingSong);
    }

    /**
     * Получить количество песен в базе
     */
    public long getSongCount() {
        return songRepository.count();
    }
}