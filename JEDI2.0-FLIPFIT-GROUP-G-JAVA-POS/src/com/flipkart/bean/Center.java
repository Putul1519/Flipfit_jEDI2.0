package com.flipkart.bean;

/**
 * 
 */
public class Center {
	private int centerId;
	private int centerOwnerId;
	private String centerName;
	private String centerLoc;
	
	 public Center(int centerId, int centerOwnerId ,String centerName, String centerLoc) {
	        this.centerId = centerId;
	        this.centerOwnerId = centerOwnerId;
	        this.centerName = centerName;
	        this.centerLoc = centerLoc;
	    }
	 
	public int getCenterId() {
		return centerId;
	}

	public void setCenterId(int centerId) {
		this.centerId = centerId;
	}
	
	public int getCenterOwnerId() {
		return centerOwnerId;
	}

	public void setCenterOwnerId(int centerId) {
		this.centerId = centerOwnerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getCenterLoc() {
		return centerLoc;
	}

	public void setCenterLoc(String centerLoc) {
		this.centerLoc = centerLoc;
	}

}
