package com.flipkart.exception;


public class LoginFailedException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public LoginFailedException(String message) {
        super(message);
        System.out.println("Unable to login, Check your username and password");
    }
}