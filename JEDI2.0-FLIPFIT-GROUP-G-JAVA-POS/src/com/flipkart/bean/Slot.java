/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class Slot {
	private String slotId;
	private boolean slotStatus;
	private String StartTime;
	private String endTime;
	private int slotCapacity;

	public String getSlotId() {
		return slotId;
	}

	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}

	public void setSlotStatus(boolean slotStatus) {
		this.slotStatus = slotStatus;
	}
	
	public boolean getSlotStatus() {
		return slotStatus;
	}


	public String getStartTime() {
		return StartTime;
	}

	public void setStartTime(String startTime) {
		StartTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getSlotCapacity() {
		return slotCapacity;
	}

	public void setSlotCapacity(int slotCapacity) {
		this.slotCapacity = slotCapacity;
	}

}
