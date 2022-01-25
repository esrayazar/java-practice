package com.esra.musicapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esra.musicapp.models.Album;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long>{
		List <Album> findAll();

}
