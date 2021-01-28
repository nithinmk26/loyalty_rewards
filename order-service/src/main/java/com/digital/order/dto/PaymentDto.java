package com.digital.order.dto;

public class PaymentDto {
	
	private int cvv ;
	private String cardName;
	private long cardNumber;
	private String cardexpire;
	private String cardtype;
	
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardexpire() {
		return cardexpire;
	}
	public void setCardexpire(String cardexpire) {
		this.cardexpire = cardexpire;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	
	
	

}
