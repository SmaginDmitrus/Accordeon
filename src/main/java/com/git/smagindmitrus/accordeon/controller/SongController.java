package com.git.smagindmitrus.accordeon.controller;

import com.git.smagindmitrus.accordeon.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class SongController {
    private SongRepository songRepository;


    SongController(SongRepository repository){
        songRepository = repository;
    }
    @RequestMapping("/status")
    public String greet(){
        return "AccrodeON works! Congrats!";
    }
}
