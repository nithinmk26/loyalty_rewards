package com.digital.loyalty.dto.request;

public class OrderDetails {
	
	private String userId;
	
	private double orderAmount;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public OrderDetails setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	/**
	 * @return the orderAmount
	 */
	public double getOrderAmount() {
		return orderAmount;
	}

	/**
	 * @param orderAmount the orderAmount to set
	 */
	public OrderDetails setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
		return this;
	}
	
	

}
