package com.esra.albums.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esra.albums.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	List <User> findAll();
	
	boolean existsByEmail(String email);
	

}
