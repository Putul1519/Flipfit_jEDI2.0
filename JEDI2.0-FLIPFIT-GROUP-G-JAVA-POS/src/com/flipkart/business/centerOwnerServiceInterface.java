/**
 * 
 */
package com.flipkart.business;

import java.util.*;

import com.flipkart.bean.*;

/**
 * 
 */
public interface centerOwnerServiceInterface {
	public void createOwner(int userId,String userPhoneNumber,String ownerGstNo,String aadharNo);
	public void updateCenterDetails(int gymId,String gymName, String gymLoc);
	public void addCenter(String centerName, String centerLoc,int ownerId);
	public List<Center> getCenterDetails(int gymId);
	
	public void addSlot(int centerId, String startTime, String endTime, int slotCapacity, String slotPrice);
	public List<Slot> viewSlots(int centerId);
	
	public List<Booking> viewAllBooking(int gymId);
	public void editYourDetails(int ownerId,String name,String email,String contactNo,String aadharNo,String gstnNo);
}
