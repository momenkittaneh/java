package com.example.Lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Lookify.models.lookify;

@Repository
public interface lookifyinterface extends CrudRepository<lookify, Long> {
	 List<lookify> findAll();   
	 
	 List<lookify> findTop10ByOrderByRatingDesc();
	    
	 List<lookify> findByArtistContaining(String artist);	    
//	 Long deleteByTitleStartingWith(String search);
	    
}
