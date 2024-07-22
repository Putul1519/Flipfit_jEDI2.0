package com.flipkart.exception;
// Exception to check if booking failed
public class BookingFailedException extends Exception {

    private static final long serialVersionUID = 1L;
    public BookingFailedException(String message) {
        super(message);
    }
}