package com.springboot.springbootwithcrud.exception;

public class Error {

	private Integer statusCode;
	private String message;
	private String description;
	
	public Error(Integer statusCode, String message, String description) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.description = description;
	}
	
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
