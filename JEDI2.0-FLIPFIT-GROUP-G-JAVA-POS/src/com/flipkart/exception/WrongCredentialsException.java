package com.flipkart.exception;

public class WrongCredentialsException extends Exception {

	private static final long serialVersionUID = 1L;

	public WrongCredentialsException() {
		super("Invalid credentials!");
	}
}