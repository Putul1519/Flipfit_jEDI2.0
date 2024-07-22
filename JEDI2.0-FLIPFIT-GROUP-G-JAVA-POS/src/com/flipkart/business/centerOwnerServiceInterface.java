package com.flipkart.business;

import java.util.*;

import com.flipkart.bean.*;

/**
 * Interface for center owner operations.
 */
public interface centerOwnerServiceInterface {
	/**
	 * Creates a new owner with the specified details.
	 * @param userId
	 * @param userPhoneNumber
	 * @param ownerGstNo
	 * @param aadharNo
	 */
	public void createOwner(int userId,String userPhoneNumber,String ownerGstNo,String aadharNo);
	/**
	 * Updates the details of a center.
	 * @param gymId
	 * @param gymName
	 * @param gymLoc
	 */
	public void updateCenterDetails(int gymId,String gymName, String gymLoc);
	/**
	 * Adds a new center.
	 * @param centerName
	 * @param centerLoc
	 * @param ownerId
	 */
	public void addCenter(String centerName, String centerLoc,int ownerId);
	/**
	 * Retrieves the details of a center.
	 * @param gymId
	 * @return A list of Center objects.
	 */
	public List<Center> getCenterDetails(int gymId);
	/**
	 * Adds a new slot.
	 * @param centerId
	 * @param startTime
	 * @param endTime
	 * @param slotCapacity
	 * @param slotPrice
	 */
	public void addSlot(int centerId, String startTime, String endTime, int slotCapacity, String slotPrice);
	/**
	 * Retrieves all slots for a center.
	 * @param centerId
	 * @return A list of Slot objects.
	 */
	public List<Slot> viewSlots(int centerId);

	/**
	 * Retrieves all bookings for a center.
	 * @param gymId
	 * @return A list of Booking objects.
	 */
	public List<Booking> viewAllBooking(int gymId);
	/**
	 * Edits the details of a center owner.
	 * @param ownerId
	 * @param name
	 * @param email
	 * @param contactNo
	 * @param aadharNo
	 * @param gstnNo
	 */
	public void editYourDetails(int ownerId,String name,String email,String contactNo,String aadharNo,String gstnNo);
}
