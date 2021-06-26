package com.example.LicenseAssignment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.LicenseAssignment.models.Person;
@Repository
public interface personrepo extends CrudRepository<Person, Long>{

	List<Person> findAll();
	
//	List<Person> findByNoLicense();
//	
//	List<Person> findByLicenseIdIsNull();

}
