package com.flipkart.bean;

public class Booking  {
	private int bookingId;
	private int customerId;
	private int centerId;
	private int slotId;
	private int transactionId;
	private int bookingAmount;
	
	//constructor
	public Booking(int bookingId, int customerId, int centerId, int slotId, int transactionId, int bookingAmount) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.centerId = centerId;
        this.slotId = slotId;
        this.transactionId = transactionId;
        this.bookingAmount = bookingAmount;
    }


	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getCenterId() {
		return centerId;
	}

	public void setCenterId(int centerId) {
		this.centerId = centerId;
	}

	public int getSlotId() {
		return slotId;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getBookingAmount() {
		return bookingAmount;
	}

	public void setBookingAmount(int bookingAmount) {
		this.bookingAmount = bookingAmount;
	}

}
