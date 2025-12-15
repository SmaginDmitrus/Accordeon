package com.git.smagindmitrus.accordeon.repository;

import com.git.smagindmitrus.accordeon.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
}
