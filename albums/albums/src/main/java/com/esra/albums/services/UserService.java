package com.esra.albums.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esra.albums.models.User;
import com.esra.albums.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	
	public List<User> getAllUSers(){
		return this.uRepo.findAll();
	}
	public User getOneUser(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
}
