/**
 * 
 */
package com.flipkart.app;

import java.util.*;

import com.flipkart.business.*;
import com.flipkart.bean.*;

/**
 * 
 */
public class GymOwnerFlipfitMenu {
	public static void login(String email, String password) {
		userServiceInterface userService = new userService();
		boolean isValid = owner.authenticateUser(email, password);

		if (isValid) {
			System.out.println("Logged in as a Center Owner");
		}

	}

	public static void showCenterOwnerOptions(String ownerId)
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
			String gymId, newGymName,newGymLoc,loc,gymName,startTime,endTime,name,phoneNumber,aadharNum,gstNum;
			int slotCap,price;
			centerOwnerServiceInterface centerOwnerService=new centerOwnerService();
			centerServiceInterface centerService=new centerService();
			switch(choice)
			{
			case 1:
				System.out.println("Enter gym name:");
				gymName=in.nextLine();
				System.out.println("Enter gym location:");
				loc=in.nextLine();
				
				centerOwnerService.addCenter(gymName,loc);
				break;
			case 2:
				
				System.out.println("Enter gym id to be modified:");
				gymId=in.nextLine();
				System.out.println("Enter new gym name:");
				newGymName=in.nextLine();
				System.out.println("Enter new location:");
				newGymLoc=in.nextLine();
				
				centerOwnerService.updateCenterDetails(gymId,newGymName,newGymLoc);
				break;
			case 3:
				System.out.println("Enter gym id:");
				gymId=in.nextLine();
				Center c=centerOwnerService.getCenterDetails(gymId);
				System.out.println("Gym details are:");
				System.out.println("Gym Name:"+c.getCenterName());
				System.out.println("Gym Loc:"+c.getCenterLoc());
				break;
			case 4:
				System.out.println("Enter gym id");
				gymId=in.nextLine();
				System.out.println("Enter the start time:");
				startTime=in.nextLine();
				System.out.println("Enter the end time:");
				endTime=in.nextLine();
				System.out.println("Enter the slot capacity:");
				slotCap=in.nextInt();
				System.out.println("Enter the price:");
				price=in.nextInt();
				centerOwnerService.addSlot(gymId, startTime, endTime, slotCap, price);
				break;
			
			case 5:
				System.out.println("Enter gym id");
				gymId=in.nextLine();
				List<Slot> allSlots=centerOwnerService.viewSlots(gymId);
				
				for(Slot s:allSlots)
				{
					System.out.println("Slot Id:"+s.getSlotId());
					System.out.println("Slot Id:"+s.getStartTime());
					System.out.println("Slot Id:"+s.getEndTime());
					if(s.getSlotStatus())
					 System.out.println("Slot Id: Slot is Available"); // we can also show all available slots at one place and same for unavailable slots.
					else{
						System.out.println("Slot Id: Slot is Unavailable");
					}
					
				}
				break;
			case 6:
				System.out.println("Enter gym id");
				gymId=in.nextLine();
				List<List<String>> allBooking=centerOwnerService.viewAllBooking(gymId);
//				for(Booking b:allBooking) // PrintList
//				{
//					System.out.println("Customer Id:"+b.getCustomerId());
//					System.out.println("Center Id:"+b.getCenterId());
//					System.out.println("Booking Id:"+b.getBookingId());
//					System.out.println("Slot id:"+b.getSlotId());
//				}
				break;
			case 7:
				System.out.println("Enter your name");
                name = in.nextLine();
                System.out.println("Enter your contact number");
                phoneNumber = in.nextLine();
                System.out.println("Enter your aadhar Number");
                aadharNum = in.next();
                System.out.println("Enter your GST Number");
                gstNum = in.next();
                
                centerOwnerService.editYourDetails(name,phoneNumber,aadharNum,gstNum);
                break;
			case 8:
				System.out.println("Thank You for using Flipfit Application!");
				flag=false;
				break;
			default:
				System.out.println("Invalid Choice!");
				
			
		}	
		}while(flag);
		
	}
}
