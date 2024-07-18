package com.flipkart.business;
import com.flipkart.bean.*;
import java.util.*;
public interface customerServiceInterface {
	public List<Center> viewCenter();
	
	public List<Booking> viewPastBooking(String custId);
	
	public List<Slot> viewSlots(String centerId);
	
	public String addBooking(String custId, String centerId, String slotId); // Return booking id & also implements slot selection here
	
	public String updateBooking(String custId, String centerId, String bookingId);
	
	public boolean deleteBooking(String custId, String centerId, String bookingId);

}
