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
		userServiceInterface owner = new userService();
		boolean isValid = owner.authenticateUser(email, password);

		if (isValid) {
			System.out.println("Logged in as a Center Owner");
		}

	}

	public static void showCenterOwnerOptions(String ownerId)
	{
		centerOwnerServiceInterface owner=new centerOwnerService();
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
			String gymId, newGymName,newGymLoc,loc,gymName,startTime,endTime;
			int slotCap,price;
			
			centerServiceInterface center=new centerService();
			switch(choice)
			{
			case 1:
				System.out.println("Enter gym name:");
				gymName=in.nextLine();
				System.out.println("Enter gym location:");
				loc=in.nextLine();
				
				owner.addCenter(gymName,loc);
				break;
			case 2:
				
				System.out.println("Enter gym id to be modified:");
				gymId=in.nextLine();
				System.out.println("Enter new gym name:");
				newGymName=in.nextLine();
				System.out.println("Enter new location:");
				newGymLoc=in.nextLine();
				
				center.setCenterDetails(gymId,newGymName,newGymLoc);
				break;
			case 3:
				System.out.println("Enter gym id:");
				gymId=in.nextLine();
				Center c=center.getCenterDetails(gymId);
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
				owner.addSlot(gymName, startTime, endTime, slotCap, price);
				break;
			
			case 5:
				System.out.println("Enter gym id");
				gymId=in.nextLine();
				List<Slot> allSlots=centerService.viewSlots();
				
				for(Slot s:allSlots)
				{
					System.out.println("Slot Id:"+s.getSlotId());
					System.out.println("Slot Id:"+s.getStartTime());
					System.out.println("Slot Id:"+s.getEndTime());
					if(s.getSlotStatus())
					 System.out.println("Slot Id: Slot is Available");
					else{
						System.out.println("Slot Id: Slot is Unavailable");
					}
					
				}
				break;
				
				
				
			    
				
			
		}
		
			
			
			
		}
		
	}

}
