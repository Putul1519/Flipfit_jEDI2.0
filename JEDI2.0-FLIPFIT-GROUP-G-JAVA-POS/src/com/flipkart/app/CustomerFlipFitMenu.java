/**
 * 
 */
package com.flipkart.app;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Scanner;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Center;
import com.flipkart.bean.Slot;
import com.flipkart.business.*;
import com.flipkart.exception.*;

/**
 * 
 */
public class CustomerFlipFitMenu {
	public static int login(String email,String password) throws UserNotFoundException,WrongCredentialsException 
	{
		userServiceInterface customer=new userService();
		int userId=customer.authenticateUser(email,password,3);
		
		if (userId>0) {
			System.out.println("Logged in as a Customer");
			return userId;
		}
		else 
		{
			throw new WrongCredentialsException();
		}
		
	}
	
	public static void showCustomerMenu(int userId) throws UserNotFoundException, InvalidChoiceException
	{
		Scanner in=new Scanner(System.in);
		boolean flag=true;
		do {
			System.out.println("Customer Menu:"
					+ "\n1. View centers"
					+"\n2. View all available slots"
					+"\n3. View past bookings"
					+"\n4. Add booking"
					+"\n5. Delete Booking"
					+"\n6. Exit");
			
			int choice=in.nextInt();
			int gymId;
			String date;
			customerServiceInterface customerService=new customerService();
			switch(choice)
			{
			case 1:
				List<Center> centers = customerService.viewCenters();
				System.out.println("All Registered Gym!");
				for (Center c : centers) {
					System.out.println("\nGym Id: " + c.getCenterId());
					System.out.println("Gym: " + c.getCenterName());
					System.out.println("Location: " + c.getCenterLoc());
				}
				break;
			case 2:
//				String temp_ = in.nextLine();
				System.out.println("Enter the id of the gym for which you want to view the available slots");
				gymId = in.nextInt();
				in.nextLine();
				System.out.println("Enter the date of the slot(dd-mm-yyyy)");
				date = in.nextLine();
				List<Slot> availableSlots = customerService.viewSlots(gymId,date);
				for(Slot s:availableSlots) {
					if(s.getSlotDate().equals(date)) {
						System.out.println("Slot id: "+s.getSlotId());
						int seats=s.getSlotMaxCapacity()-s.getSlotCurrentCapacity();
						System.out.println("Available Seats: "+seats);
						System.out.println("Slot start time: "+s.getStartTime());
						System.out.println("Slot end time: "+s.getEndTime());
						System.out.println("Slot price: "+s.getSlotPrice());
					}
				}
				break;
			case 3:
				List<Booking> bookingList=customerService.viewPastBooking(userId);
				for(Booking b:bookingList) {
					System.out.println("Center id: "+b.getCenterId());
					System.out.println("Booking id: "+b.getBookingId());
					System.out.println("Slot id: "+b.getSlotId());
					System.out.println("Booking amount: "+b.getBookingAmount());
					System.out.println("Booking date: "+b.getBookingDate());
				}
				break;
			case 4:
//				String temp2 = in.nextLine();
				System.out.println("Enter your payment details:");
				String paymentDetails = in.next();
				int transactionId=1;
				try{
					transactionId = customerService.makePayment(userId, paymentDetails);
				}
				catch (Exception e){
					System.out.println(e.getMessage());
				}
				System.out.println("Enter center id:");
				int gymBookingId = in.nextInt();
				System.out.println("Enter slot id:");
				int slotId=in.nextInt();
				LocalDate currentDate = LocalDate.now();
			    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			    String bookingDate = currentDate.format(formatter);
				try{
					customerService.createBooking(userId,slotId, gymBookingId, transactionId, bookingDate);
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				System.out.println("Enter booking id:");
				int bookingId=in.nextInt();
				customerService.deleteBooking(userId, bookingId);
				break;
			case 6:
				System.out.println("Thank you for using FlipFit!");
				flag=false;
				break;
				
			default:
				throw new InvalidChoiceException("Invalid option");
			
			}	
		}while(flag);
		in.close();
		
	}
}
