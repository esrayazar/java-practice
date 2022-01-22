package com.esra.albums.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esra.albums.models.Song;

@Repository
public interface SongRepository  extends CrudRepository<Song, Long>{


}
