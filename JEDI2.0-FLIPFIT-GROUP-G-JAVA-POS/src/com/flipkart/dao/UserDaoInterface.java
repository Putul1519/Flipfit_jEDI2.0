package com.flipkart.dao;

public interface UserDaoInterface {
	public int authenticateUser(String email,String password,int roleId);
	public  int createUser(String name,String email,String password,int roleId);
}
