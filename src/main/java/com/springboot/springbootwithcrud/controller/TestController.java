package com.springboot.springbootwithcrud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String test()
	{
		return "This project is spring boot with CRUD example";
	}
}
