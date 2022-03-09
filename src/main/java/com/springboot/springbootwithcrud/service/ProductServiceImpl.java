package com.springboot.springbootwithcrud.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.springbootwithcrud.entity.Product;
import com.springboot.springbootwithcrud.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService
{
	Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	ProductRepository productRepository;
	
	@CacheEvict(value = "ProductsByManufacturerAndPrice", allEntries = true)
	public Product saveProduct(Product p)
	{
		return productRepository.save(p);
	}
	
	public List<Product> getAllProducts()
	{
		return (List<Product>)productRepository.findAll();
	}
	
	@CacheEvict(value = "ProductsByManufacturerAndPrice", allEntries = true)
	public Product updateProduct(Product p)
	{
		return productRepository.save(p);
	}
	
	@CacheEvict(value = "ProductsByManufacturerAndPrice", allEntries = true)
	public Product deleteProduct(Product p)
	{
		productRepository.delete(p);
		
		return p;
	}
	
	@CacheEvict(value = "ProductsByManufacturerAndPrice", allEntries = true)
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
	
	@Cacheable(value = "ProductsByManufacturerAndPrice")
	public List<Product> getProductsByManufacturerAndPrice(String manufacturer, Double startingPrice, Double endingPrice)
	{
		log.info("manufacturer: "+manufacturer);
		log.info("startingPrice: "+startingPrice);
		log.info("endingPrice: "+endingPrice);
		return productRepository.findByManufacturerAndPriceBetween(manufacturer, startingPrice, endingPrice);
	}
	
	public List<Product> getAllProductsUsingPagination(Integer pageNo, Integer recordsInEachPage)
	{
		Pageable pageable = PageRequest.of(pageNo, recordsInEachPage);
		
		Page<Product> page = productRepository.findAll(pageable);
		
		return page.getContent();
	}
	
}
