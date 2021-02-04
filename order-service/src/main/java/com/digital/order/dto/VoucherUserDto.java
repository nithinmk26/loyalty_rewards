package com.digital.order.dto;

public class VoucherUserDto {
	
	private String userId;
	
    private double orderAmount; 
    
    private String voucherCode;
    
    private double utilizedLoyaltyPoints;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getVoucherCode() {
		return voucherCode;
	}

	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}

	public double getUtilizedLoyaltyPoints() {
		return utilizedLoyaltyPoints;
	}

	public void setUtilizedLoyaltyPoints(double utilizedLoyaltyPoints) {
		this.utilizedLoyaltyPoints = utilizedLoyaltyPoints;
	}
	
    
    

}
