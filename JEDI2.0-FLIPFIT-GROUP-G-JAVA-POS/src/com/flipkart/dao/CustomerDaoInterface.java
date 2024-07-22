package com.flipkart.dao;

import java.util.*;

import com.flipkart.bean.*;
import com.flipkart.bean.Slot;
import com.flipkart.exception.*;

public interface CustomerDaoInterface {
	public void createUser(int userId,String contactNo);
	public List<Center> viewCenters();
	public List<Slot> viewSlots(int gymId,String date) throws GymNotFoundException;
	public List<Booking> viewPastBooking(int userId);
	public int makePayment(int userId,String paymentDetails) throws BookingFailedException;
	
	public void createBooking(int userId,int slotId,int gymBookingId,int transactionId,String bookingDate) throws BookingFailedException;
	public void deleteBooking(int userId,int bookingId);

}
