package com.esra.albums.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esra.albums.repositories.SongRepository;

@Service
public class SongService {
	@Autowired SongRepository sRepo;
	
	public Song create(Song song) {
		return this.sRepo.save(song)
	}
	

}
