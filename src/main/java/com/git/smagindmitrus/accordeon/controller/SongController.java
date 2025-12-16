package com.git.smagindmitrus.accordeon.controller;

import com.git.smagindmitrus.accordeon.model.Song;
import com.git.smagindmitrus.accordeon.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongController {
    private SongRepository songRepository;

    @Autowired
    SongController(SongRepository repository){
        songRepository = repository;
    }
    @PostMapping("/song")
    public void addSong(@RequestBody Song song){
        songRepository.save(song);
    }
    @RequestMapping("/status")
    public String greet(){
        return "AccrodeON works! Congrats!";
    }
}
