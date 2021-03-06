package com.esra.albums.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esra.albums.models.Album;
import com.esra.albums.models.User;
import com.esra.albums.repositories.AlbumRepository;

@Service
public class AlbumService {
	@Autowired
	private AlbumRepository aRepo;
	
	
	/* (this codes = @Autowired)
	 public AlbumService(AlbumRepository repository){
	 	this.aRepo = repository;
	 }
	 */
	
	//Get Every Single Album from Database and Return To ArrayList
	public List<Album> getAllAlbums(){
		return this.aRepo.findAll();
	}
	
	//Get One Album
	public Album getOneAlbum(Long id) {
		return this.aRepo.findById(id).orElse(null);
	}
		
	//Create Album
	public Album createAlbum(Album album) {
		return this.aRepo.save(album);
	}
	
	//Update Album
	public Album editAlbum(Album album) {
		return this.aRepo.save(album);
	}
	
	//Delete Album
	public String deletealbum(Long id) {
		this.aRepo.deleteById(id);
		return "Album has been deleted";
	}
	//Like an Album 
	public void likeAlbum(User user, Album album) {
		List<User> usersWhoLiked = album.getLikers();
		usersWhoLiked.add(user);
		this.aRepo.save(album);
	}
	
	//UnLike an Album 
		public void unLikeAlbum(User user, Album album) {
			List<User> usersWhoLiked = album.getLikers();
			usersWhoLiked.remove(user);
			this.aRepo.save(album);
		}
	
				
				

}
