package com.example.Countriesthejpaversion.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Countriesthejpaversion.Services.ApiService;

@Controller
public class CountryClass {
final private ApiService apiservices;
public CountryClass(ApiService apiservices) {
	this.apiservices = apiservices;
}
@RequestMapping("/")
public String  index(Model model) {
	List<Object[]> allppi= apiservices.thecount();
	model.addAttribute("x", allppi);
return "index.jsp";
}
@RequestMapping("/city")
public String city(Model model) {
	List<Object[]> allcities=apiservices.thecities();
	model.addAttribute("y", allcities);
	return "city.jsp";
}
@RequestMapping("/languages")
public String languages(Model model) {
	List<Object[]> allanguages=apiservices.toplanaguages();
	model.addAttribute("z", allanguages);
	return "languages.jsp";
}
}