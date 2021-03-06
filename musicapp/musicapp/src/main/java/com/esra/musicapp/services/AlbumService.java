package com.esra.musicapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esra.musicapp.models.Album;
import com.esra.musicapp.models.Rating;
import com.esra.musicapp.repositories.AlbumRepository;
import com.esra.musicapp.repositories.RatingRepository;


@Service
public class AlbumService {
	@Autowired
	private AlbumRepository albumRepository;
	@Autowired
	private RatingRepository ratingRepository;
	
	//Create
	public Album create(Album  album) {
		return this.albumRepository.save(album);
	}
	
	//find all
	
	public List<Album> allAlbums(){
		return this.albumRepository.findAll();
	}
	
	//Get one
	public Album getOneAlbum(Long id) {
		return this.albumRepository.findById(id).orElse(null);
	}
	
	//Delete
	public void deleteAlbum(Long id ) {
		this.albumRepository.deleteById(id);
	}
	
	//Update
	public Album updateAlbum(Long id, String name, String description){
		Album album= getOneAlbum(id);
		album.setAlbumName(name);
		album.setDescription(description);
		return albumRepository.save(album);
	}

	//Rating
	public Rating addRating (Rating rating) {
		System.out.println("creating a rating");
		return ratingRepository.save(rating);
	}
	
	
}
