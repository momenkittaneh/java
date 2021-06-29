package com.Eventbelt.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Eventbelt.models.User;
import com.Eventbelt.models.UserEvent;
import com.Eventbelt.models.event;
import com.Eventbelt.models.message;
import com.Eventbelt.models.state;
import com.Eventbelt.service.eventserv;
import com.Eventbelt.validator.UserValidator;



@Controller
public class ps4controller {
	
	private final eventserv myevent;
	private final UserValidator valid;

	public ps4controller(eventserv myevent, UserValidator valid) {
		this.myevent = myevent;
		this.valid = valid;
	}
	
	@GetMapping("/")
	public String loginRegister(@ModelAttribute("registration")User register,HttpSession session,Model model) {
		model.addAttribute("states", state.states);

		if(session.isNew()) {
			session.setAttribute("login", false);
		}
		return"logReg.jsp";
	}
	
	@PostMapping("/register")
	public String registerProcess(@Valid @ModelAttribute("registration")User uReg,BindingResult result,RedirectAttributes rA,Model model) {
		valid.validate(uReg, result);
		model.addAttribute("states", state.states);

		if(result.hasErrors()) {
			return"logReg.jsp";
		}
		else {
			myevent.registerUser(uReg);
			rA.addFlashAttribute("success","<p class=\"alert alert-success\" role=\"alert\"> Registration Successful! You may now Log in. </p>");
			return"redirect:/";
		}
	}
	
	@PostMapping("/login")
	public String loginProcess(@RequestParam("email")String email,@RequestParam("password")String password,HttpSession session,RedirectAttributes rA) {
		if(myevent.checkLogin(email, password) == false) {
			return "redirect:/";
		}
		else {
			session.setAttribute("login", true);
			session.setAttribute("user",myevent.findByEmail(email).getId());
			return"redirect:/home";
			
		}
	}
	
	@GetMapping("/home")
		public String homePage(HttpSession session,Model model,@ModelAttribute("eventForm")event event) {
			if((boolean)session.getAttribute("login") == true) {
				User user = myevent.getUserById((Long)session.getAttribute("user"));
				model.addAttribute("user", myevent.getUserById((Long)session.getAttribute("user")));
				model.addAttribute("inState",myevent.sameStateEvents(user.getStat()));
				model.addAttribute("outState",myevent.outSideStateEvents(user.getStat()));
				model.addAttribute("joinsEvent",myevent.joinedEvents());
				model.addAttribute("states", state.states);

				return "home.jsp";
			}
			else {
				return"redirect:/";
			}
		}
	
	@PostMapping("/home")
	public String createEvent(@Valid @ModelAttribute("eventForm")event event,BindingResult result,HttpSession session,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("user", myevent.getUserById((Long)session.getAttribute("user")));
			User user = myevent.getUserById((Long)session.getAttribute("user"));
			model.addAttribute("user", myevent.getUserById((Long)session.getAttribute("user")));
			model.addAttribute("inState",myevent.sameStateEvents(user.getStat()));
			model.addAttribute("outState",myevent.outSideStateEvents(user.getStat()));
			model.addAttribute("states", state.states);

			return"home.jsp";
		}
		else {
			event newEvent = myevent.createEvent(event,(Long) session.getAttribute("user"));
			return"redirect:/events/"+newEvent.getId();
		}
	}
	
	@GetMapping("/events/{id}")
	public String eventInfo(@PathVariable("id")Long eId,Model model,HttpSession session,@ModelAttribute("addComment")message comment) {
		if((boolean)session.getAttribute("login") == true) {
			model.addAttribute("event",myevent.eventById(eId));
			model.addAttribute("user",myevent.getUserById((Long)session.getAttribute("user")));
			model.addAttribute("states", state.states);

			return "eventInfo.jsp";
		}
		else {
			return "redirect:/";
		}
		
	}
	
	@PostMapping("/events/{id}")
	public String addComment(@PathVariable("id")Long eId,HttpSession session,@Valid @ModelAttribute("addComment")message comment,BindingResult result,Model model) {
		if(result.hasErrors()) {
			if((boolean)session.getAttribute("login") == true) {
				model.addAttribute("event",myevent.eventById(eId));
				model.addAttribute("user",myevent.getUserById((Long)session.getAttribute("user")));
				model.addAttribute("states", state.states);

				return "eventInfo.jsp";
			}
			else {
				return "redirect:/";
			}
		}
		else {
			message co = new message();
			User user = myevent.getUserById((Long)session.getAttribute("user"));
			co.setMycomm(user);
			co.setComm(myevent.eventById(eId));
			myevent.addComment(comment);
			return "redirect:/events/{id}";
		}
	}
	
	@DeleteMapping("/home/{id}")
	public String deleteEvent(Model model,@PathVariable("id")Long eId,@RequestParam("userId")Long uId) {
		event event = myevent.eventById(eId);
		User user = myevent.getUserById(uId);
		model.addAttribute("states", state.states);

		if(event.getPlanner().getId() == user.getId()) {
			myevent.deleteEventById(eId);
			return"redirect:/home";
		}
		else {
			return"redirect:/logout";
		}
	}
	
	@GetMapping("home/edit/{id}")
	public String editEvent(@ModelAttribute("event")event event,@PathVariable("id")Long id,Model model,HttpSession session) {
		model.addAttribute("states", state.states);

		if((boolean)session.getAttribute("login") == true) {
			model.addAttribute("event",myevent.eventById(id));
			return"editEvent.jsp";
		}
		else {
			return"redirect:/";
		}
	}
	
	@PutMapping("home/{id}")
	public String updateEvent(@Valid @ModelAttribute("event")event event,BindingResult result,@PathVariable("id")Long id,Model model, HttpSession session) {
		User user = myevent.getUserById((Long)session.getAttribute("user"));
		model.addAttribute("states", state.states);

		if(myevent.eventById(id).getPlanner().getId() == user.getId() ) {
			if(result.hasErrors()) {
				model.addAttribute("event",myevent.eventById(id));
				return"editEvent.jsp";
			}
			else {
				event.setId(id);
				event.setPlanner(user);
				myevent.updateEvent(event);
				return"redirect:/home";
			}
			
		}
		else {
			return"redirect:/";
		}
	}
	
	@PostMapping("/home/join")
	public String joinEvent (@Valid @ModelAttribute("userEvent")UserEvent join,BindingResult result,@RequestParam("event")Long event, @RequestParam("user")Long user) {

		if(result.hasErrors()) {
			return"home.jsp";
		}
		else {
			join.setUser(myevent.getUserById(user));
			join.setEvent(myevent.eventById(event));
			myevent.userJoinEvent(join);
			return"redirect:/home";
		}
	}
	
	@DeleteMapping("/home/cancel")
	public String cancelJoin(@RequestParam("userId")Long uId,@RequestParam("id")Long eId) {
		User user = myevent.getUserById(uId);
		event event = myevent.eventById(eId);
		UserEvent cancel = myevent.findJoinedEvent(event, user);
		myevent.cancelJoin(cancel);
		return"redirect:/home";
	}
	
	
	
	
	
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return"redirect:/";
	}
	
	
}
