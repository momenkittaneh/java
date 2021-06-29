package com.example.productcat.reposetory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.productcat.models.Category;
import com.example.productcat.models.Product;
@Repository
public interface prodrepo extends CrudRepository<Product, Long> {
List<Product> findAll();

List<Product> findByCategoriesNotContains(Category category);

}
