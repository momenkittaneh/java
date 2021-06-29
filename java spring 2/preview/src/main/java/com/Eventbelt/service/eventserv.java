package com.Eventbelt.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.Eventbelt.models.User;
import com.Eventbelt.models.UserEvent;
import com.Eventbelt.models.event;
import com.Eventbelt.models.message;
import com.Eventbelt.repository.UserRepository;
import com.Eventbelt.repository.eventrepo;
import com.Eventbelt.repository.messegerepo;
import com.Eventbelt.repository.usereventrepo;


@Service
public class eventserv {
	

	final private eventrepo eve;
	final private messegerepo meso;
	final private UserRepository use;
	final private usereventrepo useeve;

	


	public eventserv(eventrepo eve, messegerepo meso, UserRepository use, usereventrepo useeve) {
		super();
		this.eve = eve;
		this.meso = meso;
		this.use = use;
		this.useeve = useeve;
	}

	public User registerUser(User user) {
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hash);
		return use.save(user);
	}
	
	public boolean checkLogin(String email,String password) {
		User user = use.findByEmail(email);
		if(user == null) {
			return false;
		}
		else {
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public User findByEmail(String email) {
		return use.findByEmail(email);
	}
	
	public User getUserById(Long id) {
		return use.findById(id).get();
	}
	
	
	public event createEvent(event event, Long id) {
		event.setPlanner(getUserById(id));
		return eve.save(event);
	}
	
	public List<event> sameStateEvents(String state){
		return eve.findByStateContains(state);
	}
	
	public List<event> outSideStateEvents(String state){
		return eve.findByStateNotContains(state);
	}
	
	public event eventById(Long id) {
		if(eve.findById(id) != null) {
			return eve.findById(id).get();
		}
		else {
			return null;
		}
	}
	
	public void deleteEventById(Long id) {
		eve.deleteById(id);
	}
	
	public void updateEvent(event event) {
		eve.save(event);
	
	}
	
	public UserEvent userJoinEvent(UserEvent join) {
		return useeve.save(join);
	}
	
	public Iterable<UserEvent> joinedEvents() {
		return useeve.findAll();
	}
	
	public void cancelJoin(UserEvent userEvent) {
		useeve.delete(userEvent);
	}
	
	public UserEvent findJoinedEvent(event event, User user) {
		return (UserEvent) useeve.findByEventAndUser(event, user);
	}
	
	public message addComment(message comment) {
		return meso.save(comment);
	}


	
	
	
}
