package com.flipkart.business;

public interface userServiceInterface {
//	public int registerUser(String userName, String userPass, String userEmail, String userRole);

	public int authenticateUser(String email, String pass,int roleId);
	public int createUser(String name,String email,String password,int roleId);

}
