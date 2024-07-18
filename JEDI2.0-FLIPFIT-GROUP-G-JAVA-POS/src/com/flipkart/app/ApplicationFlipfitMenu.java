/**
 * 
 */
package com.flipkart.app;

import java.util.Scanner;

/**
 * 
 */
public class ApplicationFlipfitMenu {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the Flipfit Application");
		System.out
				.println("Enter your choice:\n1. Login\n2. Register as Center Owner\n3. Reister as Customer\n4. Change"
						+ "Password\n5. Exit");
		int choice = in.nextInt();

		switch (choice) {
		case 1:
			login();
			break;
		case 2:
			registerCenterOwner();
			break;
		case 3:
			registerCustomer();
			break;
		case 4:
			changePassword();
			break;
		case 5:
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
		System.out.println("------- Login ------ ");
		System.out.println("Enter your email: ");
		String email = in.next();
		System.out.println("Enter your password: ");
		String password = in.next();
		System.out.println("Enter your role: \n1. Customer\n2. Center Owner\n3. Admin");
		int role = in.nextInt();
		if (role == 1) {
			CustomerFlipFitMenu.login(email,password);
		} else if (role == 2) {
			GymOwnerFlipfitMenu.login(email,password);
		} else if (role == 3) {
			
		} else {
			System.out.println("Invalid role choice");
		}

	}

}
