package com.example.productcat.reposetory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.productcat.models.Category;
import com.example.productcat.models.Product;
@Repository
public interface catrepo extends CrudRepository<Category, Long> {
List<Category> findAll();


List<Category> findByProductsNotContains(Product products);

}
