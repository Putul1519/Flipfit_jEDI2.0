/**
 * 
 */
package com.flipkart.app;

import com.flipkart.exception.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.*;
import com.flipkart.business.*;

/**
 * 
 */
public class AdminFlipfitMenu {
	
	public static int login(String email,String password) throws WrongCredentialsException
	{
		userServiceInterface user = new userService();
		int userId = user.authenticateUser(email,password,1);
		if (userId>0) {
			System.out.println("Logged in as a Admin");
			return userId;
		}
		else 
		{
			System.out.println("Incorrect email or password!");
			return -1;
		}
		
	}
	
	
	public static void showAdminOptions(int adminId) throws InvalidChoiceException
	{
		Scanner in=new Scanner(System.in);
		adminServiceInterface adminService= new adminService();
		
		int gymOwnerId;
		boolean flag=true;
		do {
			System.out.println("Admin Menu:"
					+"\n1. View All Centers"
					+ "\n2. View All Gym Owners"
					+"\n3. View All Approval Requests"
					+"\n4. Approve a Gym Owner Request"
					+"\n5. Remove a GymOwner"
					+"\n6. Exit");
			
			int choice=in.nextInt();
			
			switch(choice)
			{
			
			case 1:
				List<Center> centers =new ArrayList<>();
				centers=adminService.viewCenters();
				System.out.println("Details of All Centers");
				for(Center c: centers) {
					System.out.print("\n Name of Center: "+c.getCenterName());
					System.out.print("\n Center Id: "+c.getCenterId());
					System.out.print("\n Location of Center: "+c.getCenterLoc());
					System.out.print("\n Center Owner Id: "+c.getCenterOwnerId());
				}
			case 2:
				List<CenterOwner> allGymOwners =new ArrayList<>();
				allGymOwners = adminService.viewAllCenterOwners();
				System.out.println("Details of All Gym Owners");
				for(CenterOwner s: allGymOwners){
					System.out.println("\nGym Owner ID: " + s.getOwnerId());
				}
				break;
				
			case 3:
				
				List<CenterOwner> gymOwnerRequests =new ArrayList<>();
				gymOwnerRequests = adminService.viewRequest();
				System.out.println("Pending Requests");
				for(CenterOwner req: gymOwnerRequests){
					System.out.println("Gym owner ID: " + req.getOwnerId());
					System.out.println("Gym contact number: " + req.getContactNo());
					System.out.println("Gym owner aadhar number: " + req.getAadharNo());
					System.out.println("Gym owner gst number: " + req.getGstNo());
				}
				
				break;
			case 4:
				System.out.println("Enter Gym Owner ID to be approved: ");
				gymOwnerId = in.nextInt();
				int status=adminService.validateOwnerRequest(gymOwnerId);
				System.out.println("Request Validated");
				break;
			case 5:
			
				System.out.println("Enter Gym Owner ID to be removed: ");
				gymOwnerId = in.nextInt();
				adminService.removeGymOwner(gymOwnerId);
				System.out.println("Gym Owner Removed");
				break;
			
			case 6:
				System.out.println("Thank You for using Flipfit Application!");
				flag=false;
				break;
			default:
				throw new InvalidChoiceException("Invalid option");
			
		}
		}while(flag);
		in.close();
		
	}

}
