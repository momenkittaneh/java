package com.example.dojosandninjas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dojosandninjas.models.Dojo;
import com.example.dojosandninjas.models.Ninja;
import com.example.dojosandninjas.services.dojninjserv;



@Controller
public class dojnincontr {
private final dojninjserv newones;

public dojnincontr(dojninjserv newones) {
	this.newones = newones;
}
@RequestMapping("/")
public String index(Model model) {
	List<Ninja> nij = newones.findallninj();
	List<Dojo>  doj = newones.findall();
	model.addAttribute("nija", nij);
	model.addAttribute("dejo", doj);
	return "index.jsp";
}
@RequestMapping("/dojos/new")
public String createdojo(@ModelAttribute("makenewone") Dojo makenewone) {
	return "newdojo.jsp";
}
@PostMapping("/dojos/new")
public String create(@Valid @ModelAttribute("makenewone") Dojo makenewone, BindingResult result) {
	if(result.hasErrors()) {
		return "newdojo.jsp";
	}
	else {
		newones.createnewdojo(makenewone);
		return "redirect:/";
	}
	
}

@RequestMapping("/ninjas/new")
public String createnij(Model model,@ModelAttribute("makenewone") Ninja makenewone) {
	List<Dojo>  doj = newones.findall();
	model.addAttribute("dejo", doj);

	return "newninja.jsp";
}
@PostMapping("/ninjas/new")
public String createninja(@Valid @ModelAttribute("makenewone") Ninja makenewone, BindingResult result) {
	if(result.hasErrors()) {
		return "newninja.jsp";
	}
	else {
		newones.createnewninja(makenewone);
		return "redirect:/";

	}
}
@RequestMapping("/dojos/{id}")
public String mydojo(@PathVariable("id") Long id,Model model) {
	Dojo  doj = newones.findninjas(id);
	model.addAttribute("myninjas", doj);
	return "mydojo.jsp";
}



}
