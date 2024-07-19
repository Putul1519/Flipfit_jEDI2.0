package com.flipkart.bean;

/**
 * 
 */
public class Payment {
    private int transcationId;
    private String paymentDetails;
    private String expDate;
    private String modeOfPayment;

//  constructor
    public Payment(int transcationId, String paymentDetails, String expDate, String mode
          ) {
       this.transcationId = transcationId;
       this.paymentDetails = paymentDetails;
       this.expDate = expDate;
       this.modeOfPayment = mode;
    }


    public int getTranscationId() {
       return transcationId;
    }

    public void setTranscationId(int transcationId) {
       this.transcationId = transcationId;
    }

    public String getPaymnetDetails() {
       return paymentDetails;
    }

    public void setPaymnetDetails(String paymnetDetails) {
       this.paymentDetails = paymnetDetails;
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

}