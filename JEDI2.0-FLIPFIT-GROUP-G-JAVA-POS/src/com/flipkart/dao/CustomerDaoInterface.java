package com.flipkart.dao;

import java.util.*;

import com.flipkart.bean.*;
import com.flipkart.bean.Slot;
import com.flipkart.exception.*;

public interface CustomerDaoInterface {
	/**
	 * Creates a new user.
	 * @param userId
	 * @param contactNo
	 */
	public void createUser(int userId,String contactNo);
	/**
	 * Views all Centers.
	 *
	 * @return A list of all Centers.
	 */
	public List<Center> viewCenters();
	/**
	 * Views all slots for a gym on a particular date.
	 * @param gymId
	 * @param date
	 * @return A list of Slot objects.
	 */
	public List<Slot> viewSlots(int gymId,String date) throws GymNotFoundException;
	/**
	 * Views all past bookings for a user.
	 * @param userId
	 * @return A list of Booking objects.
	 */
	public List<Booking> viewPastBooking(int userId);
	/**
	 * Makes a payment for a user.
	 * @param userId
	 * @param paymentDetails
	 * @return 1 if the payment is successful, 0 otherwise.
	 */
	public int makePayment(int userId,String paymentDetails) throws BookingFailedException;
	/**
	 * Creates a new booking.
	 * @param userId
	 * @param slotId
	 * @param gymBookingId
	 * @param transactionId
	 * @param bookingDate
	 */
	public void createBooking(int userId,int slotId,int gymBookingId,int transactionId,String bookingDate) throws BookingFailedException;
	/**
	 * Deletes a booking.
	 * @param userId
	 * @param bookingId
	 */
	public void deleteBooking(int userId,int bookingId);

}
