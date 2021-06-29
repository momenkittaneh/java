package com.Eventbelt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Eventbelt.models.event;

@Repository
public interface eventrepo extends CrudRepository<event, Long>{
	List<event> findByStateContains(String stat);
	List<event> findByStateNotContains(String stat);


}
