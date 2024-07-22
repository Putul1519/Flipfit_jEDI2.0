package com.flipkart.exception;
// Exception to check if user not found
public class UserNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message) {
		super(message);
		System.out.println("User not found!!"); 
	}
}