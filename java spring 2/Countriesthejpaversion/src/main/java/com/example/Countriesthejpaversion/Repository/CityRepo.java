package com.example.Countriesthejpaversion.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.Countriesthejpaversion.models.City;

public interface CityRepo extends CrudRepository<City, Long> {
	 @Query(value="select countries.name , count(cities.name) as total\r\n"
		 		+ "FROM cities\r\n"
		 		+ "JOIN countries ON cities.country_id = countries.id\r\n"
		 		+ "GROUP BY countries.name\r\n"
		 		+ "ORDER BY total DESC;" + "",nativeQuery = true)
		 List<Object[]> totalCiteies();
}
