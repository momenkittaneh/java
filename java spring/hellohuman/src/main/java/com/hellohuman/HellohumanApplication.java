package com.hellohuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller

public class HellohumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellohumanApplication.class, args);
	}

}
@RequestMapping("/")
public String render1(@RequestParam(value="firstName",required=false, defaultValue="Human")String firstName) {
	
		model.addAttribute("firstName",firstName);
	
	
	return "/views/hello.jsp";
}