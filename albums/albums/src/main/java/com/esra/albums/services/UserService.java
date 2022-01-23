package com.esra.albums.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
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
	public User registerUser(User user) {
		//Generate the Hash
		String hash= BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		//Set the hashed password on the users password field
		user.setPassword(hash);
		//Save that new user password and the user object to the database
		return this.uRepo.save(user);
	}
	
	public boolean authenticateUser(String email, String password) {
		//Query the user by email
		User user =this.uRepo.findByEmail(email);
		if (user==null){
			return false;
		}
		//Step 2 check provided email against email in database
		return BCrypt.checkpw(password, user.getPassword());
	}
	
	public User getUserByEmail(String email) {
		return this.uRepo.findByEmail(email);
	}
	
}
