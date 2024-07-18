/**
 * 
 */
package com.flipkart.app;
import com.flipkart.business.*;

/**
 * 
 */
public class CustomerFlipFitMenu {
	public static void login(String email,String password)
	{
		userServiceInterface customer=new userService();
		boolean isValid=customer.authenticateUser(email,password);
		
		if(isValid) {
			System.out.println("Logged in as a Customer");
		}
		
	}
}
