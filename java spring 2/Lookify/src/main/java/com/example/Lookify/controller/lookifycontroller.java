package com.example.Lookify.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Lookify.models.lookify;
import com.example.Lookify.services.lookifyservice;

@Controller
public class lookifycontroller {

	final private lookifyservice myfun ;

	public lookifycontroller(lookifyservice myfun) {
		super();
		this.myfun = myfun;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/search")
	public String Search(@RequestParam("artist") String artist, Model model) {
		model.addAttribute("songs",	myfun.songsContainingArtist(artist));
		model.addAttribute("artist", artist);
		return "searched.jsp";
	}

	@RequestMapping("/dashboard")
	public String show(Model model) {
		List<lookify> looking = myfun.allsongs();
		model.addAttribute("thesongs", looking);
		return "dashboard.jsp";
	}
	
	@RequestMapping("/search/top10")
	public String top10(Model model) {
		List<lookify> looking = myfun.topTen();
		model.addAttribute("top10", looking);
		return "top10.jsp";
	}
	
	@RequestMapping("/songs/{id}")
	public String details(Model model,@PathVariable("id") Long id) {
		lookify look = myfun.findsong(id);
		model.addAttribute("song", look);
		return "details.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String newsong(@ModelAttribute("newsong") lookify newsong) {
		return "newsong.jsp";
	}
	@RequestMapping(value="/newsong", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("newsong") lookify newsong, BindingResult result) {
		if (result.hasErrors()) {
			return "newsong.jsp";
		}
		else {
		
			myfun.createsong(newsong.getTitle(), newsong.getArtist(), newsong.getRating());
			return "redirect:/";
		}
	}
	@RequestMapping(value="songs/delete/{id}")
	public String deleting(@PathVariable("id") Long id) {
		myfun.delete(id);
		return "index.jsp";
	}


}

