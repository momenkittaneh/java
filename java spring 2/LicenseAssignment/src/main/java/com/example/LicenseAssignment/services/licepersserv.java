package com.example.LicenseAssignment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.LicenseAssignment.models.License;
import com.example.LicenseAssignment.models.Person;
import com.example.LicenseAssignment.repositories.licencerepo;
import com.example.LicenseAssignment.repositories.personrepo;

@Service
public class licepersserv {

	final private licencerepo licerep;
	final private personrepo persrep;
    public static int licenseNumber;
	
	
	public licepersserv(licencerepo licerep, personrepo persrep) {
		super();
		this.licerep = licerep;
		this.persrep = persrep;
	}

	public static Integer getLicenseNumber() {
		return licenseNumber;
	}

	public static void setLicenseNumber(Integer licenseNumber) {
		licepersserv.licenseNumber = licenseNumber;
	}

	public Person addPerson(Person person) {
		return persrep.save(person);
	}
	
	public List<Person> allPersons() {
		return persrep.findAll();
	}
	
	public License addLicense(License license){
		
		return licerep.save(license);
	}
	
	public String stringLicenseNumber(int num) {
		String format = String.format("%06d", num);
		return format;
	}
	public String generateLicenseNumber() {
		if(licerep.findTopByOrderByNumberDesc().isEmpty()) {
			licenseNumber +=1;
			return stringLicenseNumber(licenseNumber); 
		}
		else {
			List<License> top = licerep.findTopByOrderByNumberDesc();
			licenseNumber = 1+(Integer.parseInt(top.get(0).getNumber()));
			return stringLicenseNumber(licenseNumber); 
		}
		
	}
	
	public Optional<License> getLicense(Long id) {
		return licerep.findById(id);
	}
	
	
}
