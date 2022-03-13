package com.springboot.springbootwithcrud.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springbootwithcrud.entity.Product;
import com.springboot.springbootwithcrud.service.ProductService;

@RestController
public class SchedulerController {
	
	Logger log = LoggerFactory.getLogger(SchedulerController.class);
	
	@Autowired
	ProductService productService;

//	@Scheduled(initialDelay = 1000, fixedDelay = 5000)
	@Scheduled(cron = "0 0/1 * * * ?")
	public void getAllProductDetails()
	{
		log.info("Entred into Scheduler....");
		
		List<Product> products = productService.getAllProducts();
		products.stream().forEach(p -> log.info(p.getManufacturer()+" "+p.getName()+" "+ p.getPrice()));
		
	}
	
	@Scheduled(initialDelay = 1000, fixedDelay = 5000)
	public void getAllProductDetails1()
	{
		log.info("Entred into Scheduler getAllProductDetails1()....");
		
	}
}
