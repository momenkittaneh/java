package com.example.productcat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.productcat.models.Category;
import com.example.productcat.models.Product;
import com.example.productcat.models.categories_products;
import com.example.productcat.reposetory.thejoiner;
import com.example.productcat.reposetory.catrepo;
import com.example.productcat.reposetory.prodrepo;

@Service
public class catprodserv {
	final private catrepo mycat; 
	final private prodrepo mypro;
	final private thejoiner joining;
	public catprodserv(catrepo mycat, prodrepo mypro,thejoiner join) {
		super();
		this.mycat = mycat;
		this.mypro = mypro;
		this.joining = join;
	}
	public List<Product> allofthem(){
		List<Product> allofmyprod = mypro.findAll();
		return allofmyprod;
	}
	public List<Category> allofcat(){
		List<Category> allofmycat = mycat.findAll();
		return allofmycat;
	}
	public Product myprod(Long id) {
		Optional<Product> thepro = mypro.findById(id);
		if (thepro.isPresent()) {
			return thepro.get();
		}
		else {return null;}
	}
	public Category mycat(Long id) {
		Optional<Category> thecat = mycat.findById(id);
		if(thecat.isPresent()) {return thecat.get();}
		else {return null;}
	}
	public Product createprod(Product pro) {
		return mypro.save(pro);
	}
	public Category creatcat(Category cat) {
		return mycat.save(cat);
	}
	public List<Category> notsort(Long id){
		return mycat.findByProductsNotContains(myprod(id));
	}
	public List<Product> notsortprod(Long id){
		return mypro.findByCategoriesNotContains(mycat(id));
	}
	public categories_products makeconnection(categories_products cata) {
		return  joining.save(cata);
	}

}
