package com.springboot.springbootwithcrud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.springbootwithcrud.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>
{
	public List<Product> findByManufacturer(String manufacturer);
	
	public List<Product> findByName(String name);
	
	public List<Product> findByPriceBetween(Double startingPrice, Double endingPrice);
}
