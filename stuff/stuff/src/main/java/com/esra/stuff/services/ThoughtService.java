package com.esra.stuff.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esra.stuff.models.Thought;
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
	
	public List<Thought> allthoughts(){
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
	
}
