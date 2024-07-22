package com.flipkart.business;
import com.flipkart.bean.*;
import java.util.*;
public interface customerServiceInterface {
	public void createCustomer(int userId, String contactNo);
	public List<Center> viewCenters();
	public List<Slot> viewSlots(int gymId,String date);
	public List<Booking> viewPastBooking(int userId);
	
	public int makePayment(int userId,String paymentDetails);
	
	public void createBooking(int userId,int slotId,int gymBookingId,int transactionId,String bookingDate);
	public void deleteBooking(int userId,int bookingId);

}
