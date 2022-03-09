package com.springboot.springbootwithcrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<Error> handleBadRequest(MissingServletRequestParameterException ex)
	{
		Error error = new Error(400, "Bad Request", "Due to Bad Request we are unable to process your request");
		
		return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Error> handleAllExceptions(Exception ex)
	{
		Error error = new Error(500, "Internal Server Error", "Something went wrong, please try again!");
		
		return new ResponseEntity<Error>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
