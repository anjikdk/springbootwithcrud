package com.springboot.springbootwithcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.springbootwithcrud.entity.Product;
import com.springboot.springbootwithcrud.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	ProductRepository productRepository;
	
	public Product saveProduct(Product p)
	{
		return productRepository.save(p);
	}
	
	public List<Product> getAllProducts()
	{
		return (List<Product>)productRepository.findAll();
	}
	
	public Product updateProduct(Product p)
	{
		return productRepository.save(p);
	}
	
	public Product deleteProduct(Product p)
	{
		productRepository.delete(p);
		
		return p;
	}
	
	public boolean deleteProductById(Integer id)
	{
		productRepository.deleteById(id);
		
		return true;
	}
	
	public List<Product> getProductsByManufacturer(String manufacturer)
	{
		return productRepository.findByManufacturer(manufacturer);
	}
	
	public List<Product> getProductsByPrice(Double startingPrice, Double endingPrice)
	{
		return productRepository.findByPriceBetween(startingPrice, endingPrice);
	}
}
