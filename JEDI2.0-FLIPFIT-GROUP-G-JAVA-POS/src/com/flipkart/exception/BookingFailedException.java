package com.flipkart.exception;

public class BookingFailedException extends Exception {

    private static final long serialVersionUID = 1L;
    public BookingFailedException(String message) {
        super(message);
    }
}