package com.example.Languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Languages.models.language;

@Repository
public interface LanguageRepository extends CrudRepository<language, Long>{
    List<language> findAll();
//    List<language> findByDescriptionContaining(String search);
//    Long countByTitleContaining(String search);
//    Long deleteByTitleStartingWith(String search);
}
