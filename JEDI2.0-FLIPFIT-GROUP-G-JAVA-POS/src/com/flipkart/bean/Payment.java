package com.flipkart.bean;

/**
 * 
 */
public class Payment {
	private int transcationId;

	public int getTranscationId() {
		return transcationId;
	}

	public void setTranscationId(int transcationId) {
		this.transcationId = transcationId;
	}

	public String getPaymnetDetails() {
		return paymnetDetails;
	}

	public void setPaymnetDetails(String paymnetDetails) {
		this.paymnetDetails = paymnetDetails;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	private String paymnetDetails;
	private String expDate;
	private String modeOfPayment;

}
