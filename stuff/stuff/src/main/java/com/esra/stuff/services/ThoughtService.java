package com.esra.stuff.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esra.stuff.models.Thought;
import com.esra.stuff.models.User;
import com.esra.stuff.repositories.ThoughtRepository;

@Service
public class ThoughtService {
	@Autowired
	private ThoughtRepository ThoughtRepository;
	
	//Create
	public Thought create(Thought thought) {
		return this.ThoughtRepository.save(thought);
	}
	
	//find all
	
	public List<Thought> allThoughts(){
		return this.ThoughtRepository.findAll();
	}
	
	//Get one
	public Thought getOneThought(Long id) {
		return this.ThoughtRepository.findById(id).orElse(null);
	}
	
	//Delete
	public void deleteThought(Long id ) {
		this.ThoughtRepository.deleteById(id);
	}
	
	//Like
	public void likeThought(User user, Thought thought) {
		List<User> usersWhoLiked = thought.getLikers();
		usersWhoLiked.add(user);
		this.ThoughtRepository.save(thought);
	}
	
	//Unlike
	public void unlikeThought(User user, Thought thought) {
		List<User> usersWhoLiked = thought.getLikers();
		usersWhoLiked.remove(user);
		this.ThoughtRepository.save(thought);
	}
}
