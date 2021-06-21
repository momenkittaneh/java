package com.example.dojosurvey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class DojosurveyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DojosurveyApplication.class, args);
	}
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
    @RequestMapping(value="/check", method= RequestMethod.POST)
	public String check(@RequestParam(value="name") String name,@RequestParam(value="city") String city
				,@RequestParam(value="language") String language,@RequestParam(value="comment") String comment,Model model) {
		
		return "redirect:/result";
	}
    @RequestMapping("/result")
    public String result(Model model,@RequestParam(value="name") String name,@RequestParam(value="city") String city
			,@RequestParam(value="language") String language,@RequestParam(value="comment") String comment) {
    	model.addAttribute("name", name);
		model.addAttribute("city", city);
		model.addAttribute("language", language);
		model.addAttribute("comment", comment);

    	if( language.equals("java"))
    	{
    		return "java.jsp";
    	}
    	return "result.jsp";

    }
}
