package com.example.LicenseAssignment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.LicenseAssignment.models.License;
@Repository
public interface licencerepo extends CrudRepository<License, Long>{

	List<License> findAll();
	List<License> findTopByOrderByNumberDesc();
}
