package com.springboot.springbootwithcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springbootwithcrud.entity.Product;
import com.springboot.springbootwithcrud.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	ProductService productService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Product saveProduct(@RequestBody Product product)
	{
		return productService.svaeProduct(product);
		
	}
}
