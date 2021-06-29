package com.example.Countriesthejpaversion.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.Countriesthejpaversion.models.Language;

public interface LangRepo  extends CrudRepository<Language, Long> {
@Query(value=" select countries.name, languages.language , languages.percentage from languages\r\n"
		+ "JOIN countries ON languages.country_id = countries.id\r\n"
		+ "where languages.percentage>'89'\r\n"
		+ "order by languages.percentage desc;"+ "",nativeQuery = true)
List<Object[]> topLanguages();
}