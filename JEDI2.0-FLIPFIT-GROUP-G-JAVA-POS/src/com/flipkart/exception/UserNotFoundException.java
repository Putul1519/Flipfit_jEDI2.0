package com.flipkart.exception;

public class UserNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message) {
		super(message);
		System.out.println("User not found!!"); 
	}
}