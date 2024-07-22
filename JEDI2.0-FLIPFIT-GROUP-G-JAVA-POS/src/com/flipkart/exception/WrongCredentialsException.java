package com.flipkart.exception;
// Exception to check if wrong credentials
public class WrongCredentialsException extends Exception {

	private static final long serialVersionUID = 1L;

	public WrongCredentialsException() {
		super("Invalid credentials!");
	}
}