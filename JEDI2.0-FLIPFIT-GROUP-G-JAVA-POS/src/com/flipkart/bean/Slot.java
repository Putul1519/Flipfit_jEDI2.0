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
    private String startTime;
    private String endTime;
    private int slotMaxCapacity;
    private int slotPrice;
    private int slotCurrentCapacity;
    private int centerId;
    private String slotDate;
    
    public Slot(String slotId, boolean slotStatus, String startTime, String endTime, 
            int slotMaxCapacity, int slotPrice, int slotCurrentCapacity, 
            int centerId, String slotDate)
    {
    	this.slotId = slotId;
        this.slotStatus = slotStatus;
        this.startTime = startTime;
        this.endTime = endTime;
        this.slotMaxCapacity = slotMaxCapacity;
        this.slotPrice = slotPrice;
        this.slotCurrentCapacity = slotCurrentCapacity;
        this.centerId = centerId;
        this.slotDate = slotDate;
    }

    public int getSlotPrice() {
       return slotPrice;
    }

    public void setSlotPrice(int slotPrice) {
       this.slotPrice = slotPrice;
    }

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
       return startTime;
    }

    public void setStartTime(String startTime) {
       this.startTime = startTime;
    }

    public String getEndTime() {
       return endTime;
    }

    public void setEndTime(String endTime) {
       this.endTime = endTime;
    }

	public int getSlotMaxCapacity() {
		return slotMaxCapacity;
	}

	public void setSlotMaxCapacity(int slotMaxCapacity) {
		this.slotMaxCapacity = slotMaxCapacity;
	}

	public int getCenterId() {
		return centerId;
	}

	public void setCenterId(int centerId) {
		this.centerId = centerId;
	}

	public String getSlotDate() {
		return slotDate;
	}

	public void setSlotDate(String slotDate) {
		this.slotDate = slotDate;
	}

	public int getSlotCurrentCapacity() {
		return slotCurrentCapacity;
	}

	public void setSlotCurrentCapacity(int slotCurrentCapacity) {
		this.slotCurrentCapacity = slotCurrentCapacity;
	}

}