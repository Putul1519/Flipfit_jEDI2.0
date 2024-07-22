package com.flipkart.dao;

public interface UserDaoInterface {
	/**
	 * Authenticates a user.
	 *
	 * @param email The email of the user.
	 * @param password The password of the user.
	 * @param roleId The role ID of the user.
	 * @return 1 if the user is authenticated, 0 otherwise.
	 */
	public int authenticateUser(String email,String password,int roleId);
	/**
	 * Creates a new user.
	 * @param name
	 * @param email
	 * @param password
	 * @param roleId
	 * @return
	 */
	public  int createUser(String name,String email,String password,int roleId);
}
