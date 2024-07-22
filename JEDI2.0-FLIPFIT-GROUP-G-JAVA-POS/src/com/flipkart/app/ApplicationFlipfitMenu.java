/**
 * 
 */
package com.flipkart.app;

import java.util.Scanner;

import com.flipkart.business.*;
import com.flipkart.exception.*;

/**
 * 
 */
public class ApplicationFlipfitMenu {
	public static void main(String args[]) throws UserNotFoundException {
		Scanner in = new Scanner(System.in);
		System.out.println("-------Welcome to the Flipfit Application-------");
		System.out.println(
				"\nEnter your choice:\n1. Login\n2. Register as Center Owner\n3. Register as Customer\n4. Exit");
		int choice = in.nextInt();
		switch (choice) {
		case 1:
			login();
			break;
		case 2:
			registerAsCenterOwner();
			break;
		case 3:
			registerAsCustomer();
			break;
		case 4:
			System.out.println("Thank you for using FlipFit!");
			in.close();
			break;
		default:
			System.out.println("Invalid choice!");
		}
		in.close();
	}

	public static void login() {

		Scanner in = new Scanner(System.in);
		System.out.println("------- Login-------");
		System.out.println("Enter your email: ");
		String email = in.next();
		System.out.println("Enter your password: ");
		String password = in.next();
		System.out.println("Enter role id: \n1.Admin\n2.Gym Owner\n3.Customer");
		int roleId = in.nextInt();
		int userId = -1;
		try {
			userId = GymOwnerFlipfitMenu.login(email, password, roleId);
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}

		if (userId == -1) {
			System.out.println("Try Again!");
			in.close();
			return;
		}
		if (roleId == 2)
			try {
				GymOwnerFlipfitMenu.showCenterOwnerOptions(userId);
			} catch (Exception e) {
				System.out.println("Error:" + e.getMessage());
			}
		else if (roleId == 1)
			try {
				AdminFlipfitMenu.showAdminOptions(userId);
			} catch (Exception e) {
				System.out.println("Error:" + e.getMessage());
			}
		else if (roleId == 3)
			try {
				CustomerFlipFitMenu.showCustomerMenu(userId);
			} catch (Exception e) {
				System.out.println("Error:" + e.getMessage());
			}
		else
			System.out.println("Try Again!");
		in.close();

	}

	public static void registerAsCustomer() throws UserNotFoundException {
		customerServiceInterface customerService = new customerService();
		userServiceInterface userService = new userService();
		Scanner in = new Scanner(System.in);

		System.out.println("------Register as Customer-------");
		System.out.println("Enter your name: ");
		String userName = in.nextLine();
		System.out.println("Enter your phone number: ");
		String userPhoneNumber = in.next();
		System.out.println("Enter your email: ");
		String userEmail = in.next();
		System.out.println("Enter your password: ");
		String userPassword = in.next();

		int userId = userService.createUser(userName, userEmail, userPassword, 3);
		System.out.println("user id" + userId);
		if (userId > 0) {
			customerService.createCustomer(userId, userPhoneNumber);
			System.out.println("You have successfully registered as Customer");
			login();
		}
		in.close();
	}

	public static void registerAsCenterOwner() throws UserNotFoundException {
		centerOwnerServiceInterface ownerService = new centerOwnerService();
		userServiceInterface userService = new userService();
		Scanner in = new Scanner(System.in);

		System.out.println("------Register as Gym Owner-------");
		System.out.println("Enter your name: ");
		String userName = in.nextLine();
		System.out.println("Enter your phone number: ");
		String userPhoneNumber = in.next();
		System.out.println("Enter your email: ");
		String userEmail = in.next();
		System.out.println("Enter your password: ");
		String userPassword = in.next();
		System.out.println("Enter your gst number: ");
		String ownerGstNo = in.next();
		System.out.println("Enter your aadhar number: ");
		String aadharNo = in.next();
		int userId = userService.createUser(userName, userEmail, userPassword, 3);
		if (userId > 0) {
			ownerService.createOwner(userId, userPhoneNumber, ownerGstNo, aadharNo);
			System.out.println("You have successfully registered as Customer");
			login();
		}
		in.close();

	}
}
