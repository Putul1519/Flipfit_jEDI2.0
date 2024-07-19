/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class CenterOwner{
	private int userId; 
	private int ownerId;
	private boolean approvalStatus;
	private String contactNo;
	private String aadharNo;
	private String gstNo;
	
	public CenterOwner(int userId, int ownerId, boolean approvalStatus, String contactNo, String aadharNo, String gstNo) {
		this.userId = userId;
		this.ownerId = ownerId;
	    this.approvalStatus = approvalStatus;
	    this.contactNo = contactNo;
	    this.aadharNo = aadharNo;
	    this.gstNo = gstNo;		
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public boolean getApprovalStatus() {
		return approvalStatus;
		
	}

	public void setApprovalStatus(boolean approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

}
