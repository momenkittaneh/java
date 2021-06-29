package com.Eventbelt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Eventbelt.models.message;

@Repository
public interface messegerepo extends CrudRepository<message, Long> {

}
