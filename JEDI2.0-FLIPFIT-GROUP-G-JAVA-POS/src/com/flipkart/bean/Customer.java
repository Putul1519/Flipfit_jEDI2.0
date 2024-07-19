/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class Customer {

	private int customerId;         // Unique identifier for the customer
	private String customerName;    // Name of the customer
	private String customerPhone;   // Phone number of the customer
	private String customerAddress; // Address of the customer
	private int userId;             // Identifier of the associated user


	public Customer(int customerId, String customerName, String customerPhone, String customerAddress, int userId) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerAddress = customerAddress;
		this.userId = userId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}


	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}


	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}

