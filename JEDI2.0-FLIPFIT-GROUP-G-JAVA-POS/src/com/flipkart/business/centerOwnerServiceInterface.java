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
	
	public List<Center> viewCenter(String centerId);
	
	public String addCenter(String centerName, String centerLoc);
	
	public String addSlot(String centerId, String startTime, String endTime, int slotCapacity, int slotPrice);
	
	public boolean updateCenterDetails(String centerId);
	
	public void viewSlots(String centerId);
	
	public void editDetails(String ownerId);
	

}
