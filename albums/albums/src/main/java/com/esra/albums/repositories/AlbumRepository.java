package com.esra.albums.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esra.albums.models.Album;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long>{
	List<Album> findAll();//SELECT *FROM albums
	//List<Album> findByAlbumNameContain(String containing);
	//order 
//	List<Album> findTop10OrderByYearAsc();
//	boolean existsByAlbumName(String albumName);
	

}
