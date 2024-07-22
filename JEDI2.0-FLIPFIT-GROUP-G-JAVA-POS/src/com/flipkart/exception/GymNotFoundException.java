package com.flipkart.exception;
// Exception to check if gym not found
public class GymNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

	public GymNotFoundException(int gymId) {
        super("Gym Centre " + gymId + " not found!");
    }
}