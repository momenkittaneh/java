package com.example.DisplayDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@Controller
public class DisplayDateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisplayDateApplication.class, args);
	}
    @RequestMapping("/")
    public String index() {
    	return "index.jsp";
    }
    @RequestMapping("/time")
    public String time(Model model) {
    	 java.util.Date hello = new java.util.Date();
    	    SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss a");  

    	model.addAttribute("Date", formatter.format(hello));
    	return "time.jsp";
    }
    
    @RequestMapping("/date")
    public String date(Model model) {
    	java.util.Date hello = new java.util.Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  

	model.addAttribute("Date", formatter.format(hello));
	return "date.jsp";
    }
}
