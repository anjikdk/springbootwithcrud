package com.springboot.springbootwithcrud.service;

import java.util.List;

import com.springboot.springbootwithcrud.entity.Product;

public interface ProductService {

	public Product saveProduct(Product p);
	
	public List<Product> getAllProducts();
	
	public Product updateProduct(Product p);
	
	public Product deleteProduct(Product p);
	
	public boolean deleteProductById(Integer id);
	
	public List<Product> getProductsByManufacturer(String manufacturer);
	
	public List<Product> getProductsByPrice(Double startingPrice, Double endingPrice);
}

