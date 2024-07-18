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
	public void updateCenterDetails(String gymId,String gymName, String gymLoc);
	public void addCenter(String centerName, String centerLoc);
	public String addSlot(String centerId, String startTime, String endTime, int slotCapacity, int slotPrice);
	public Center getCenterDetails(String gymId);
	public void viewSlots(String centerId);
	public List<List<String>> viewAllBooking(String gymId);
	public void editYourDetails(String name,String contactNo,String aadharNo,String gstnNo);
	

}
