package com.springboot.springbootwithcrud.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	public Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Product saveProduct(@RequestBody Product product)
	{
		logger.info("Start execution saveProduct method...");
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
	
	@RequestMapping(value = "/getProductsByManufacturerAndPrice", method = RequestMethod.GET)
	public List<Product> getProductsByManufacturerAndPrice(@RequestParam("manufacturer") String manufacturer,
			@RequestParam("priceStart") Double priceStart, @RequestParam("priceEnd") Double priceEnd)
	{
		return productService.getProductsByManufacturerAndPrice(manufacturer, priceStart, priceEnd);
	}
	
	@RequestMapping(value = "/fetch", method = RequestMethod.GET)
	public List<Product> getAllProductsUsingPagination(@RequestParam("pageNo") Integer pageNo, @RequestParam("recordsInEachPage") Integer recordsInEachPage)
	{
		return productService.getAllProductsUsingPagination(pageNo, recordsInEachPage);
	}
}

