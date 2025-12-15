package com.git.smagindmitrus.accordeon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import javax.annotation.processing.Generated;
import java.util.List;

@Entity
@Data
public class Song {
    @Id
    private Long id;
    private String author;
    private List<String> lyrics;
    private String chords;

}
