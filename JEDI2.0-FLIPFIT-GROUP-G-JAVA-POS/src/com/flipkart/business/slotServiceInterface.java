/**
 * 
 */
package com.flipkart.business;

/**
 * 
 */
public interface slotServiceInterface {
	
	public String bookSlot(String custId, String centerId, String slotId); // Return booking Id
	
	public boolean checkAvailability(String slotId);

}
