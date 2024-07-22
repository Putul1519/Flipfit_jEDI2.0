/**
 * 
 */
package com.flipkart.business;

import java.util.HashMap;
import java.util.List;
import com.flipkart.dao.*;

import com.flipkart.bean.*;

/**
 * Service class implementing operations for customer management.
 */
public class customerService implements customerServiceInterface {
	CustomerDaoInterface customerDao=new CustomerDaoImpl();
	/**
	 * Creates a new customer with the specified details.
	 * @param userId
	 * @param contactNo
	 */
	public void createCustomer(int userId, String contactNo) {
		customerDao.createUser(userId, contactNo);
	}
	/**
	 * Views all Centers.
	 *
	 * @return A list of all Centers.
	 */
	public List<Center> viewCenters(){
		return customerDao.viewCenters();		
	}
	/**
	 * Views all slots for a gym on a particular date.
	 * @param gymId
	 * @param date
	 * @return A list of Slot objects.
	 */
	public List<Slot> viewSlots(int gymId,String date){
		try {
		  return customerDao.viewSlots(gymId, date);
		}
		catch(Exception e){
			System.out.println("Error:"+e.getMessage());
		}
		return null;
	}
	/**
	 * Views all past bookings for a user.
	 * @param userId
	 * @return A list of Booking objects.
	 */
	public List<Booking> viewPastBooking(int userId)
	{
		return customerDao.viewPastBooking(userId);
	}
	/**
	 * Makes a payment for a user.
	 * @param userId
	 * @param paymentDetails
	 * @return 1 if the payment is successful, 0 otherwise.
	 */
	public int makePayment(int userId,String paymentDetails) {
		try {
		return customerDao.makePayment(userId,paymentDetails);
		}catch(Exception e) {
			System.out.println("Error:"+e.getMessage());
		}
		return 0;
	}
	/**
	 * Creates a new booking.
	 * @param userId
	 * @param slotId
	 * @param gymBookingId
	 * @param transactionId
	 * @param bookingDate
	 */
	public void createBooking(int userId,int slotId,int gymBookingId,int transactionId,String bookingDate) {
		try {
		customerDao.createBooking(userId,slotId,gymBookingId,transactionId,bookingDate);
		}catch(Exception e) {
			System.out.println("Error:"+e.getMessage());
		}
	}
	/**
	 * Deletes a booking.
	 * @param userId
	 * @param bookingId
	 */
	public void deleteBooking(int userId,int bookingId) {
		customerDao.deleteBooking(userId,bookingId);
	}


}
