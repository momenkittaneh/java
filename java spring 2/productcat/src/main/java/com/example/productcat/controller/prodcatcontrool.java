package com.example.productcat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

import com.example.productcat.models.Category;
import com.example.productcat.models.Product;
import com.example.productcat.models.categories_products;
import com.example.productcat.service.catprodserv;


@Controller
public class prodcatcontrool {

	final private catprodserv myserv;

	public prodcatcontrool(catprodserv myserv) {
		super();
		this.myserv = myserv;
	}
	@RequestMapping("/")
	public String red() {
		return "redirect:/products/new";
	}
	@RequestMapping("/products/new")
	public String newprod(Model model) {
		model.addAttribute("newprod", new Product());
		
		return "newprod.jsp";
	}
	@PostMapping("/products/new")
	public String createprod(@Valid @ModelAttribute("newprod") Product newprod, BindingResult result) {
		if(result.hasErrors()) {
			return "newprod.jsp";
		}
		else {
			myserv.createprod(newprod);
			return "redirect:/";

		}	
	}
	@RequestMapping("/catagories/new")
	public String newcat(Model model)
	{
		model.addAttribute("newcat", new Category());
		return "newcat.jsp";
	}
	@PostMapping("/catagories/new")
	public String createcat(@Valid @ModelAttribute("newcat") Category newcat, BindingResult result) {
		if(result.hasErrors()) {
			return "newcat.jsp";
		}
		else {
			myserv.creatcat(newcat);
			return "redirect:/catagories/{id}";

		}	
	}
	@RequestMapping("/products/{id}")
	public String showprod(@PathVariable("id") Long id,Model model,@ModelAttribute("product")categories_products product) {
		model.addAttribute("cate", myserv.notsort(id));
		model.addAttribute("myprod", myserv.myprod(id));
		return "proddetails.jsp";
	}
	@PostMapping("/products/{id}")
	public String addprod(@PathVariable("id") Long id,Model model,@ModelAttribute("product")categories_products product) {
		product.setProduct(myserv.myprod(id));
		myserv.makeconnection(product);

		
		return "redirect:/products/{id}";

	}
	
	@RequestMapping("/catagories/{id}")
	public String showcat(@PathVariable("id") Long id,Model model,@ModelAttribute("product")categories_products product) {
		model.addAttribute("prod", myserv.notsortprod(id));
		model.addAttribute("mycat", myserv.mycat(id));
		return "catdetails.jsp";
	}
	@PostMapping("/catagories/{id}")
	public String addcat(@PathVariable("id") Long id,Model model,@ModelAttribute("product")categories_products product) {
		product.setCategory(myserv.mycat(id));
		myserv.makeconnection(product);
		return "redirect:/catagories/{id}";
	}
}
