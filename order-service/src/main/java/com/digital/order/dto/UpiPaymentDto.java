package com.digital.order.dto;

public class UpiPaymentDto {
	
	private long phonenumber;
	private String upiUrl;
	private int transactionId;
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getUpiUrl() {
		return upiUrl;
	}
	public void setUpiUrl(String upiUrl) {
		this.upiUrl = upiUrl;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	
	
	
	

}
