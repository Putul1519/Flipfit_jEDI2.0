/**
 * 
 */
package com.flipkart.business;
import com.flipkart.dao.*;

import java.util.*;

import com.flipkart.bean.*;

/**
 * 
 */
public class centerOwnerService implements centerOwnerServiceInterface{
	CenterOwnerDaoInterface ownerDao=new CenterOwnerDaoImpl();
	
	public void createOwner(int userId,String userPhoneNumber,String ownerGstNo,String aadharNo) {
		ownerDao.createOwner(userId,userPhoneNumber,ownerGstNo,aadharNo);
	}
	
	public void addCenter(String centerName, String centerLoc,int ownerId) {
		ownerDao.addCenter(centerName, centerLoc, ownerId);
		System.out.println("Gym Registered!");
	}
	
	public void updateCenterDetails(int gymId,String gymName, String gymLoc)
	{
		ownerDao.updateCenterDetails(gymId, gymName, gymLoc);
		System.out.println("Update Successfull!");
		
	}
	public List<Center> getCenterDetails(int gymId)
	{
		return ownerDao.getCenterDetails(gymId);
	}
	public void addSlot(int gymId, String startTime, String endTime, int slotCap,String price)
	{
		ownerDao.addSlot(gymId,startTime,endTime,slotCap,price);
		System.out.println("Slot Added!");
		
	}
	public List<Slot> viewSlots(int centerId)
	{
		return ownerDao.viewSlots(centerId);
	}
	public List<Booking> viewAllBooking(int gymId) // try using 2D matrix
	{
		return ownerDao.viewAllBooking(gymId);
	}
	public void editYourDetails(int ownerId,String name,String email,String contactNo,String aadharNo,String gstnNo)
	{
		ownerDao.editYourDetails(ownerId, name, email, contactNo, aadharNo, gstnNo);
	}
}
