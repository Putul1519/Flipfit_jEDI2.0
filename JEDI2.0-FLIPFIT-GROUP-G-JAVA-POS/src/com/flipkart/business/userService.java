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
	public int authenticateUser(String email, String pass,int roleId) {
		return userDao.authenticateUser(email, pass, roleId);
	}
	public int createUser(String name,String email,String password,int roleId) {
		return userDao.createUser(name,email,password,roleId);
	}

}
