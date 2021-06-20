package com.example.TheCode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SpringBootApplication
@Controller
public class TheCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheCodeApplication.class, args);
	}
@RequestMapping("/")
public String index() {
	
	return "index.jsp";
}
@RequestMapping("/check")
public String check(@RequestParam(value="thecode") String code) {
	
	if(code.contentEquals("bushido")) {
		return "redirect:/sucsess";
	}
	else {
		return "redirect:/createError";
	}
	
}
@RequestMapping("/sucsess")
	public String sucsess() {
		return "sucsess.jsp";}
	
//	@RequestMapping("/error")
//		public String error(RedirectAttributes redirectAttributes) {
//			redirectAttributes.addFlashAttribute("error", "You must Train harder!");
//		
//			return "redirect:/";
//		}
	 @RequestMapping("/createError")
	    public String flashMessages(RedirectAttributes redirectAttributes) {
	        redirectAttributes.addFlashAttribute("error", "You must Train harder!");
	        return "redirect:/";

}}

