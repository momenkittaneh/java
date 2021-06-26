package com.example.Lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Lookify.models.lookify;
import com.example.Lookify.repositories.lookifyinterface;

@Service
public class lookifyservice {

	final private lookifyinterface mylooki;


	public lookifyservice(lookifyinterface mylooki) {
		this.mylooki = mylooki;
	}
	public lookify createsong(String title,String artist,Integer rating) {
		lookify newsong = new lookify();
		newsong.setTitle(title);
		newsong.setArtist(artist);
		newsong.setRating(rating);
		mylooki.save(newsong);
		return newsong;
	}

	public List<lookify> allsongs(){
		return mylooki.findAll();
	}
	public lookify findsong(Long id) {
		Optional<lookify> findsong = mylooki.findById(id);
		if (findsong.isPresent()) {
			return findsong.get();
		}
		else
			return null;
	}
	public List<lookify> topTen(){
		return mylooki.findTop10ByOrderByRatingDesc();
	}
	public void delete(Long id) {
		Optional<lookify> optionalBook = mylooki.findById(id);
        lookify y =optionalBook.get();
        mylooki.delete(y);
	}
	public List<lookify> songsContainingArtist(String artist) {
		return mylooki.findByArtistContaining(artist);
	}

	
}
