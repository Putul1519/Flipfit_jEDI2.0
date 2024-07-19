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
    private int slotPrice;
    
    public Slot(String StartTime,String endTime,int slotCapacity,int price)
    {
       this.StartTime=StartTime;
       this.endTime=endTime;
       this.slotCapacity=slotCapacity;
       this.slotPrice=price;
       this.slotStatus=false;
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