package com.Eventbelt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Eventbelt.models.User;
import com.Eventbelt.models.UserEvent;
import com.Eventbelt.models.event;

@Repository
public interface usereventrepo extends CrudRepository<UserEvent,Long> {
	List<UserEvent> findByEventContains(event event);
	List<UserEvent> findByEventAndUser(event event, User user);
	
}