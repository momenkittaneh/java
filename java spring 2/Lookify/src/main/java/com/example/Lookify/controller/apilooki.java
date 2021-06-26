package com.example.Lookify.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Lookify.models.lookify;
import com.example.Lookify.services.lookifyservice;

@RestController    //if disabled return to error
public class apilooki {
	final private lookifyservice myfun ;

	public apilooki(lookifyservice myfun) {
		this.myfun = myfun;
	}
	@RequestMapping(value="/api/")
	public List<lookify> index(){
		return myfun.allsongs();
	}
	@RequestMapping(value="/api/createsong", method=RequestMethod.POST)
	public lookify create(@RequestParam(value="title") String title,@RequestParam(value="artist") String artist,@RequestParam(value="rating") Integer rating) {
		lookify newsong =myfun.createsong(title, artist, rating);
		return newsong;
	}
	
	@RequestMapping(value="/api/song/{id}")
	public lookify sepsong(@PathVariable("id") Long id) {
	lookify looking = myfun.findsong(id);
	return looking;}
	
	@RequestMapping(value="/api/song/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
	myfun.delete(id);
	}
	
}
