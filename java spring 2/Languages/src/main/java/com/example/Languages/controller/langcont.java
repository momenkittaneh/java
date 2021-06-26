package com.example.Languages.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Languages.models.language;
import com.example.Languages.services.languageservice;

@Controller
public class langcont {
	private final languageservice langnew;

	public langcont(languageservice langnew) {
		this.langnew = langnew;

	}

	@RequestMapping(value = "/languages")
	public String index(Model model) {
		List<language> la = langnew.alllanguages();
		model.addAttribute("lang", la);
		model.addAttribute("makenewone",new language());

		return "index.jsp";
	}
	@RequestMapping(value="/languages", method = RequestMethod.POST)
    public String create(Model model,@Valid @ModelAttribute("makenewone") language makenewone, BindingResult result) {
		List<language> la = langnew.alllanguages();
		model.addAttribute("lang", la);

        if (result.hasErrors()) {
            return "index.jsp";
        } else {
        	langnew.createlanguage(makenewone.getName(),makenewone.getCreator(),makenewone.getVersion());
            return "redirect:/";
        }
    }

	@RequestMapping(value = "/languages/{id}/edit")
	public String showed(Model model,@PathVariable("id") Long id) {
		language la =  langnew.findlanguage(id);
		model.addAttribute("language", la);

		return "edit.jsp";
	}
	@RequestMapping("/languages/{id}")
	public String info(@PathVariable("id") Long id, Model model) {
		language la = langnew.findlanguage(id);
		model.addAttribute("language",la);
		return "details.jsp";
	}
	@RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
	public String editLang(@Valid @ModelAttribute("language") language language, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("error here");
			return "edit.jsp";
		}
		else {
			langnew.updatelanguage(language);
			return"redirect:/languages";
		}
	}
	@RequestMapping(value="/languages/delete/{id}")
	public String Delete(@PathVariable("id") Long id) {
		langnew.deletelanguage(id);
		return "redirect:/";
	}


}
@Controller
class red{
@RequestMapping(value = "/")
public String wenttohome(Model model) {
	return "redirect:/languages";

}}