package com.springboot.springbootwithcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "Product API", version = "2.0", description = "Product Information"))
@EnableCaching
@SpringBootApplication
public class SpringbootwithcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootwithcrudApplication.class, args);
	}

}
