package com.example.ninjagold;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class NinjagoldApplication {

	public static void main(String[] args) {
		SpringApplication.run(NinjagoldApplication.class, args);
	}
@RequestMapping("/")
public String index(HttpSession session) {
	if (session.isNew()) {
		session.setAttribute("gold", 0);
		session.setAttribute("activities", new ArrayList<String>());

	} 
	return "index.jsp";
}
@RequestMapping("/earning")
public String earn(@RequestParam (value="earn") String earn,HttpSession session) {
	Random r = new Random();
	ArrayList<String> temp_activities = (ArrayList<String>) session.getAttribute("activities");
  	 java.util.Date time = new java.util.Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd yyyy,  hh:mm:ss a");  

	if(earn.equals("farm")) {
		int earning = r.nextInt(20-10)+10;
		temp_activities.add(0, "Earned " + earning + " gold from the farm! " + formatter.format(time));
		session.setAttribute("activities", temp_activities);
		int total =(Integer) session.getAttribute("gold") + earning;
		session.setAttribute("gold", total);
		return "redirect:/";}
	else if(earn.equals("cave")) {
		int earning = r.nextInt(10-5)+5;
		temp_activities.add(0, "Earned " + earning + " gold from the cave! " + formatter.format(time));
		session.setAttribute("activities", temp_activities);
		int total =(Integer) session.getAttribute("gold") + earning;
		session.setAttribute("gold", total);
		return "redirect:/";}
	else if(earn.equals("house")) {
		int earning = r.nextInt(5-2)+2;
		temp_activities.add(0, "Earned " + earning + " gold from the house! " + formatter.format(time));
		session.setAttribute("activities", temp_activities);
		int total =(Integer) session.getAttribute("gold") + earning;
		session.setAttribute("gold", total);
		return "redirect:/";
}
	else if(earn.equals("casino")) {
		int earning = r.nextInt(50-(-50))-50;
		int total =(Integer) session.getAttribute("gold") + earning;
		if(earning>0) {
			temp_activities.add(0, "Earned " + earning + " gold from the casino! " + formatter.format(time));
		}
		else {
			temp_activities.add(0, "Lost " + earning + " gold from the casino! " + formatter.format(time));

		}
		session.setAttribute("activities", temp_activities);
		session.setAttribute("gold", total);}
	return "redirect:/";
}}


