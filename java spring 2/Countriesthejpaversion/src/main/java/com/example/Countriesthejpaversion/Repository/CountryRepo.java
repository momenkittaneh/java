package com.example.Countriesthejpaversion.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.Countriesthejpaversion.models.Country;

public interface CountryRepo  extends CrudRepository<Country, Long> {
	 @Query(value="select language, percentage, countries.name FROM languages \r\n"
	 		+ "INNER JOIN countries ON countries.id = languages.country_id\r\n"
	 		+ "where language =\"Slovene\"\r\n"
	 		+ "ORDER BY percentage DESC; " + "",nativeQuery = true)
	 List<Object[]> countriesSpeaksSolvene();
}
