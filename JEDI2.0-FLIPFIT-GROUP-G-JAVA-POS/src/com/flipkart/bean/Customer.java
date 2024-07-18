/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class Customer extends User {
	private String contactNo;
	private String gender;
	private String customerName;

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getcustomerName() {
		return gender;
	}
	
	public void setcustomerName(String customerName) {
		this.customerName=customerName;
	}
	

}
