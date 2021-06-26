package com.example.LicenseAssignment.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.LicenseAssignment.models.License;
import com.example.LicenseAssignment.models.Person;
import com.example.LicenseAssignment.services.licepersserv;



@Controller
public class mycontrol {
	final private licepersserv myrepo;

	public mycontrol(licepersserv myrepo) {
		this.myrepo = myrepo;
	}
	@RequestMapping("/")
	public String notHere() {
		return "redirect:/createuser";
	}
	
	@GetMapping("/createuser")
	public String addPerson(@ModelAttribute("person") Person peroson) {
		return "new.jsp";
	}
	
	@PostMapping("createuser") 
	public String processAddPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		else {
			myrepo.addPerson(person);
			return "redirect:/license/new";
		}
	}
	
	@GetMapping("license/new")
	public String addLicense(@ModelAttribute("license")License license, Model model) {
		List<Person> persons = myrepo.allPersons();
		model.addAttribute("persons",persons);
		return"newlice.jsp";
		
	}
	
	@PostMapping("license/new")
	public String processLicense(@Valid @ModelAttribute("license") License license, BindingResult result,Model model) {
		if(result.hasErrors()) {
			List<Person> persons = myrepo.allPersons();
			model.addAttribute("persons",persons);
			return "newlice.jsp";
		}
		else {
			String number = myrepo.generateLicenseNumber();
			license.setNumber(number);
			myrepo.addLicense(license);
			return"redirect:/persons/"+license.getId();
			
		}
	}
	
	@RequestMapping("/persons/{Id}")
	public String setUpView(@PathVariable("Id")Long id,Model model) {
		Date date = myrepo.getLicense(id).get().getExpirationDate();
		String pattern ="MM/dd/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		model.addAttribute("date",simpleDateFormat.format(date));
		model.addAttribute("license",myrepo.getLicense(id).get());
		return"person.jsp";
	}
	
	
	
}


