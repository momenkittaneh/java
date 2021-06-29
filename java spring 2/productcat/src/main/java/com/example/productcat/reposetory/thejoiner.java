package com.example.productcat.reposetory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.productcat.models.categories_products;

@Repository
public interface thejoiner extends CrudRepository<categories_products, Long> {

}
