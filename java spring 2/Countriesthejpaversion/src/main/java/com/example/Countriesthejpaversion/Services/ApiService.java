package com.example.Countriesthejpaversion.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Countriesthejpaversion.Repository.CityRepo;
import com.example.Countriesthejpaversion.Repository.CountryRepo;
import com.example.Countriesthejpaversion.Repository.LangRepo;

@Service
public class ApiService {
  private final CityRepo cityRepository;
  private final CountryRepo CountryRepository;
  private final LangRepo LangRepository;
public ApiService(CityRepo cityRepository, CountryRepo countryRepository, LangRepo langRepository) {
	this.cityRepository = cityRepository;
	CountryRepository = countryRepository;
	LangRepository = langRepository;
}

// function for country  goes here
public List<Object[]> thecount(){
	return CountryRepository.countriesSpeaksSolvene();	
	
}
//function for city  goes here
public List<Object[]> thecities(){
	return cityRepository.totalCiteies();
}
//function for languages goes here
public List<Object[]> toplanaguages(){
	return LangRepository.topLanguages();
}
}