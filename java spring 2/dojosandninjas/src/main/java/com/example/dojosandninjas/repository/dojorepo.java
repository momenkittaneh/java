package com.example.dojosandninjas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.dojosandninjas.models.Dojo;

public interface dojorepo extends CrudRepository<Dojo, Long> {
	List<Dojo> findAll();

}
