package com.esra.stuff.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esra.stuff.models.Thought;

@Repository
public interface ThoughtsRepository extends CrudRepository<Thought, Long>{
	List <Thought> findAll();

}
