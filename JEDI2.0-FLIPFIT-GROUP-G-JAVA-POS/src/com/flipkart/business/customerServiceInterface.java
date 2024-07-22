package com.flipkart.business;
import com.flipkart.bean.*;
import java.util.*;

/**
 * Interface for customer operations.
 */
public interface customerServiceInterface {
	/**
	 * Creates a new customer with the specified details.
	 * @param userId
	 * @param contactNo
	 */
	public void createCustomer(int userId, String contactNo);
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
	public List<Slot> viewSlots(int gymId,String date);
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
	public int makePayment(int userId,String paymentDetails);
	/**
	 * Creates a new booking.
	 * @param userId
	 * @param slotId
	 * @param gymBookingId
	 * @param transactionId
	 * @param bookingDate
	 */
	public void createBooking(int userId,int slotId,int gymBookingId,int transactionId,String bookingDate);
	/**
	 * Deletes a booking.
	 * @param userId
	 * @param bookingId
	 */
	public void deleteBooking(int userId,int bookingId);

}
