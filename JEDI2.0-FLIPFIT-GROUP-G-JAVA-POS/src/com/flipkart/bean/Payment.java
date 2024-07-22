package com.flipkart.bean;

/**
 * 
 */
public class Payment {
    private int transcationId;
    private String upiId;
    private String paymentDate;
    private int customerId;



    public Payment(int transactionId, String upiId, String paymentDate, int customerId) {
    	this.transcationId = transactionId;
        this.upiId = upiId;
        this.paymentDate = paymentDate;
        this.customerId = customerId;
     
    }
	/**
	 * getters and setters
	 */

    public int getTranscationId() {
       return transcationId;
    }

    public void setTranscationId(int transcationId) {
       this.transcationId = transcationId;
    }


	public String getUpiId() {
		return upiId;
	}


	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}


	public String getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}