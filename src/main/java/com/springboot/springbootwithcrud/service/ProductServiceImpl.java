package com.springboot.springbootwithcrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.springbootwithcrud.entity.Product;
import com.springboot.springbootwithcrud.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	ProductRepository productRepository;
	
	public Product svaeProduct(Product p)
	{
		return productRepository.save(p);
		
	}
}
