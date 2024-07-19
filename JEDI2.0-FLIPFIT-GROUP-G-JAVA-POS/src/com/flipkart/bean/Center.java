package com.flipkart.bean;

/**
 * 
 */
public class Center {
	private int centerId;
	private String centerName;
	private String centerLoc;
	
	 public Center(int centerId, String centerName, String centerLoc) {
	        this.centerId = centerId;
	        this.centerName = centerName;
	        this.centerLoc = centerLoc;
	    }
	 
	public int getCenterId() {
		return centerId;
	}

	public void setCenterId(int centerId) {
		this.centerId = centerId;
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
