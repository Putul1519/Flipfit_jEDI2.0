package com.flipkart.exception;

import java.io.InvalidObjectException;

public class InvalidChoiceException extends InvalidObjectException {

    private static final long serialVersionUID = 1L;
    public InvalidChoiceException(String message) {
        super(message);
        System.out.println("Please enter valid choice"); 
    }
}