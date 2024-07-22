package com.flipkart.business;

public interface userServiceInterface {
	public int authenticateUser(String email, String pass,int roleId);
	public int createUser(String name,String email,String password,int roleId);

}
