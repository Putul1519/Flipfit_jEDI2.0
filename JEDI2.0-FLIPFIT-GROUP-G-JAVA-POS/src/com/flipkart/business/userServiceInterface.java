package com.flipkart.business;

public interface userServiceInterface {
	public int registerUser(String userName, String userPass, String userEmail, String userRole);

	public boolean authenticateUser(String email, String pass);

}
