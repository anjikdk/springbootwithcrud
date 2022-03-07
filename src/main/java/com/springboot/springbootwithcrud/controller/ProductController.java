package com.springboot.springbootwithcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		return productService.saveProduct(product);
		
	}
	
	// http://localhost:8080/product/save
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Product> getAllProducts()
	{
		return productService.getAllProducts();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product)
	{
		return productService.updateProduct(product);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public Product deleteProductByObject(@RequestBody Product product)
	{
		return productService.deleteProduct(product);
	}
	
	@RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
	public boolean deleteProductById(@PathVariable("id") Integer id)
	{
		return productService.deleteProductById(id);
	}
	
	@RequestMapping(value = "/getProductsByManufacturer", method = RequestMethod.GET)
	public List<Product> getProductsByManufacturer(@RequestParam("manufacturer") String manufacturer)
	{
		return productService.getProductsByManufacturer(manufacturer);
	}
	
	@RequestMapping(value = "/getProductsByPrice", method = RequestMethod.GET)
	public List<Product> getProductsByPrice(@RequestParam("priceStart") Double priceStart, @RequestParam("priceEnd") Double priceEnd)
	{
		return productService.getProductsByPrice(priceStart, priceEnd);
	}
}

