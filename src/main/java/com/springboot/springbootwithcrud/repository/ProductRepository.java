package com.springboot.springbootwithcrud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.springbootwithcrud.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>
{

}
