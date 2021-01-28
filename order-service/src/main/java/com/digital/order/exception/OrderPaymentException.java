package com.digital.order.exception;

public class OrderPaymentException extends LoyaltyRewardsGlobalAppException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderPaymentException() {
		super();
	}

	public OrderPaymentException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public OrderPaymentException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public OrderPaymentException(String arg0) {
		super(arg0);
	}

	public OrderPaymentException(Throwable arg0) {
		super(arg0);
	}
	
	

}
