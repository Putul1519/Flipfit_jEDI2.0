package com.flipkart.dao;

import java.util.*;

import com.flipkart.bean.*;
/**
 * Interface for Center Owner operations.
 */
public interface CenterOwnerDaoInterface {
      /**
       * Adds a new center.
       * @param centername
       * @param centerLoc
       * @param ownerId
       */
      public void addCenter(String centername, String centerLoc, int ownerId);
      /**
       * Updates the details of a center.
       * @param gymId
       * @param gymName
       * @param gymLoc
       */
      public void updateCenterDetails(int gymId, String gymName, String gymLoc);
      /**
       * Retrieves the details of a center.
       * @param gymId
       * @return A list of Center objects.
       */
      public List<Center> getCenterDetails(int gymId);
      /**
       * Adds a new slot.
       * @param gymId
       * @param startTime
       * @param endTime
       * @param slotCap
       * @param price
       */
      public void addSlot(int gymId, String startTime, String endTime, int slotCap,String price);
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
       * Edit your details.
       * @param ownerId
       * @param name
       * @param email
       * @param contactNo
       * @param aadharNo
       * @param gstnNo
       */
      public void editYourDetails(int ownerId,String name,String email, String contactNo, String aadharNo, String gstnNo);
      /**
       *
       * Create a new owner with the specified details.
       * @param userId
       * @param userPhoneNumber
       * @param ownerGstNo
       * @param aadharNo
       */
      public void createOwner(int userId,String userPhoneNumber,String ownerGstNo,String aadharNo);

}