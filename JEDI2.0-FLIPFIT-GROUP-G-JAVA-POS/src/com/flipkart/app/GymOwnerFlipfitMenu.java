/**
 * 
 */
package com.flipkart.app;

import java.util.*;


import com.flipkart.business.*;
import com.flipkart.exception.*;
import com.flipkart.bean.*;

/**
 * 
 */
public class GymOwnerFlipfitMenu {
	public static int login(String email, String password,int roleId) throws UserNotFoundException,WrongCredentialsException{
		userServiceInterface user = new userService();
		int userId = user.authenticateUser(email,password,roleId);
		if (userId>0) {
			System.out.println("Log in successful!");
			return userId;
		}
		else 
		{
			System.out.println("Incorrect email or password!");
			return -1;
		}
	}

	public static void showCenterOwnerOptions(int userId) throws UserNotFoundException, InvalidChoiceException
	{
		Scanner in=new Scanner(System.in);
		boolean flag=true;
		do {
			System.out.println("Gym Owner Menu:"
					+ "\n1. Register a new center"
					+"\n2. Edit gym details"
					+"\n3. View gym details"
					+"\n4. Add a new slot"
					+"\n5. View slots"
					+"\n6. View all bookings"
					+"\n7. Edit your profile"
					+"\n8. Exit");
			
			int choice=in.nextInt();
			String emailAddress,newGymName,newGymLoc,loc,gymName,startTime,endTime,name,phoneNumber,aadharNum,gstNum,price;
			int slotCap,gymId,centerId;
			centerOwnerServiceInterface centerOwnerService=new centerOwnerService();
			switch(choice)
			{
			case 1:
				System.out.println("Enter gym name:");
				gymName=in.next();
				System.out.println("Enter gym location:");
				loc=in.next();
				
				centerOwnerService.addCenter(gymName,loc,userId);
				break;
			case 2:
				System.out.println("Enter gym id:");
				gymId=in.nextInt();
				System.out.println("Enter new gym name:");
				newGymName=in.next();
				System.out.println("Enter new location:");
				newGymLoc=in.next();
				
				centerOwnerService.updateCenterDetails(gymId,newGymName,newGymLoc);
				break;
			case 3:
				List<Center> centerList=centerOwnerService.getCenterDetails(userId);
				System.out.println("Center Details:");
				for(Center c:centerList) {
//					System.out.println(i+"Center Details:");
					System.out.println("Center Id:"+c.getCenterId());
					System.out.println("Center Name:"+c.getCenterName());
					System.out.println("Center Location:"+c.getCenterLoc());
					System.out.println();
					
				}
				break;
			case 4:
				System.out.println("Enter gym id");
				gymId=in.nextInt();
				System.out.println("Enter the start time:");
				startTime=in.next();
				System.out.println("Enter the end time:");
				endTime=in.next();
				System.out.println("Enter the slot capacity:");
				slotCap=in.nextInt();
				System.out.println("Enter the price:");
				price=in.next();
				centerOwnerService.addSlot(gymId, startTime, endTime, slotCap, price);
				break;
			
			case 5:
				System.out.println("Enter center id");
				centerId=in.nextInt();
				List<Slot> allSlots=centerOwnerService.viewSlots(centerId);
				System.out.println();
				System.out.println("Slot Details:");
				
				for(Slot c:allSlots) {
//					System.out.println(i+"Slot Details:");
					System.out.println("Slot Id:"+c.getSlotId());
					System.out.println("Start Time:"+c.getStartTime());
					System.out.println("End Time:"+c.getEndTime());
					System.out.println("Max Capacity:"+c.getSlotMaxCapacity());
					int cap=c.getSlotMaxCapacity()-c.getSlotCurrentCapacity();
					System.out.println("Current Capacity:"+cap);
					System.out.println("Date:"+c.getSlotDate());
					if(cap!=0)
						System.out.println("Status: Available");
					else
						System.out.println("Status: Unavailable");
					System.out.println();
				}				
				break;
			case 6:
				System.out.println("Enter gym id");
				gymId=in.nextInt();
				System.out.println();
				System.out.println("Booking Details:");
				
				List<Booking> allBooking=centerOwnerService.viewAllBooking(gymId);
				for(Booking b:allBooking) // PrintList
				{
//					System.out.println(i+"Booking Details:");
					System.out.println("Customer Id:"+b.getCustomerId());
					System.out.println("Booking Id:"+b.getBookingId());
					System.out.println("Slot id:"+b.getSlotId());
					System.out.println();
				}
				break;
			case 7:
				System.out.println("Enter your name");
                name = in.next();
                System.out.println("Enter your contact number");
                phoneNumber = in.next();
                System.out.println("Enter your email address");
                emailAddress = in.next();
                System.out.println("Enter your aadhar Number");
                aadharNum = in.next();
                System.out.println("Enter your GST Number");
                gstNum = in.next();
                
                centerOwnerService.editYourDetails(userId,name,emailAddress,phoneNumber,aadharNum,gstNum);
                break;
			case 8:
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
