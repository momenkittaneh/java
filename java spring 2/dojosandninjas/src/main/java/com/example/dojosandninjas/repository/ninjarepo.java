package com.example.dojosandninjas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.dojosandninjas.models.Ninja;

public interface ninjarepo extends CrudRepository<Ninja, Long> {
List<Ninja> findAll();
}
