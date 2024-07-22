/**
 * 
 */
package com.flipkart.business;

import java.util.HashMap;
import java.util.List;
import com.flipkart.dao.*;

import com.flipkart.bean.*;

/**
 * 
 */
public class customerService implements customerServiceInterface {
	CustomerDaoInterface customerDao=new CustomerDaoImpl();
	public void createCustomer(int userId, String contactNo) {
		customerDao.createUser(userId, contactNo);
	}
	public List<Center> viewCenters(){
		return customerDao.viewCenters();		
	}
	public List<Slot> viewSlots(int gymId,String date){
		try {
		  return customerDao.viewSlots(gymId, date);
		}
		catch(Exception e){
			System.out.println("Error:"+e.getMessage());
		}
		return null;
	}
	public List<Booking> viewPastBooking(int userId)
	{
		return customerDao.viewPastBooking(userId);
	}
	public int makePayment(int userId,String paymentDetails) {
		try {
		return customerDao.makePayment(userId,paymentDetails);
		}catch(Exception e) {
			System.out.println("Error:"+e.getMessage());
		}
		return 0;
	}
	public void createBooking(int userId,int slotId,int gymBookingId,int transactionId,String bookingDate) {
		try {
		customerDao.createBooking(userId,slotId,gymBookingId,transactionId,bookingDate);
		}catch(Exception e) {
			System.out.println("Error:"+e.getMessage());
		}
	}
	public void deleteBooking(int userId,int bookingId) {
		customerDao.deleteBooking(userId,bookingId);
	}


}
