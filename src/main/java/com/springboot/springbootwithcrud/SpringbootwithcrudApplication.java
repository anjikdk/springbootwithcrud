package com.springboot.springbootwithcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringbootwithcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootwithcrudApplication.class, args);
	}

}
