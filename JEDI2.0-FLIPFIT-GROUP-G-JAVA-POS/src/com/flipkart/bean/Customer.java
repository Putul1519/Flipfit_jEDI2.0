/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class Customer {

	private int customerId;         // Unique identifier for the customer
	private String customerPhone;   // Phone number of the customer
	private int userId;             // Identifier of the associated user


	public Customer(int customerId, String customerName, String customerPhone, String customerAddress, int userId) {
		this.customerId = customerId;
		
		this.customerPhone = customerPhone;
		
		this.userId = userId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}


	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}

