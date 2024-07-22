package com.flipkart.dao;

import java.util.*;

import com.flipkart.bean.*;

public interface CenterOwnerDaoInterface {
      public void addCenter(String centername, String centerLoc, int ownerId);
      public void updateCenterDetails(int gymId, String gymName, String gymLoc);
      public List<Center> getCenterDetails(int gymId);
      public void addSlot(int gymId, String startTime, String endTime, int slotCap,String price);
      public List<Slot> viewSlots(int centerId);
      public List<Booking> viewAllBooking(int gymId);
      public void editYourDetails(int ownerId,String name,String email, String contactNo, String aadharNo, String gstnNo);
      public void createOwner(int userId,String userPhoneNumber,String ownerGstNo,String aadharNo);

}