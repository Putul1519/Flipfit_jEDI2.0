/**
 * 
 */
package com.flipkart.business;
import com.flipkart.dao.*;

/**
 * 
 */
public class userService implements userServiceInterface {
	UserDaoInterface userDao=new UserDaoImpl();
	/**
	 * Authenticates a user.
	 *
	 * @param email The email of the user.
	 * @param pass The password of the user.
	 * @param roleId The role ID of the user.
	 * @return 1 if the user is authenticated, 0 otherwise.
	 */
	public int authenticateUser(String email, String pass,int roleId) {
		return userDao.authenticateUser(email, pass, roleId);
	}
	/**
	 * Creates a new user.
	 *
	 * @param name The name of the user.
	 * @param email The email of the user.
	 * @param password The password of the user.
	 * @param roleId The role ID of the user.
	 * @return 1 if the user is created, 0 otherwise.
	 */
	public int createUser(String name,String email,String password,int roleId) {
		return userDao.createUser(name,email,password,roleId);
	}

}
