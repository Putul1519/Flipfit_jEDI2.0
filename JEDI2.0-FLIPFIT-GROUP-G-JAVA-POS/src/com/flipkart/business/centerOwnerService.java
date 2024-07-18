/**
 * 
 */
package com.flipkart.business;

import java.util.*;

import com.flipkart.bean.*;

/**
 * 
 */
public class centerOwnerService implements centerOwnerServiceInterface{
	
	public void addCenter(String centerName, String centerLoc) {
		Center cen=new Center();
		cen.setCenterName(centerName);
		cen.setCenterLoc(centerLoc);
		centerServiceInterface center=new centerService();
		center.setCenterDetails(cen);
		
	}
	
	public void updateCenterDetails(String gymId,String gymName, String gymLoc)
	{
		// Fetch the data from DB and change it.
		
	}
	public Center getCenterDetails(String gymId)
	{
		// Fetch the data and return the Center object
		Center c=new Center();
		return c;
	}
	public void addSlot(String gymId, String startTime, String endTime, int slotCap,int price)
	{
//		Slot s= new Slot(startTime,endTime,slotCap,price);
//		// fetch last slod id and increment it by +1;
//		String id=0;
//		s.setSlotId(id);
		// Insert into slot table
		
		
	}
	public List<Slot> viewSlot(String gymId)
	{
		// Fetch all the rows from slot table for the above gymId and convert each row into slot object
		// merge all the slot objects into a list and return it.
	}
	public List<List<String>> viewAllBooking(String gymId) // try using 2D matrix
	{
		// Fetch all the rows from booking, slot, customer and center tables for the above gymId and convert each row into slot object
		// merge all the slot objects into a list and return it.
	}
	public void editYourDetails(String name,String contactNo,String aadharNo,String gstnNo)
	{
		// write update query to update the details of the customer table
	}
	
	

}
