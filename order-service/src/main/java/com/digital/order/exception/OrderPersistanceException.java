package com.digital.order.exception;

public class OrderPersistanceException extends LoyaltyRewardsGlobalAppException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5858963167879129288L;

	public OrderPersistanceException() {
		super();
	}

	public OrderPersistanceException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public OrderPersistanceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		}

	public OrderPersistanceException(String arg0) {
		super(arg0);
	}

	public OrderPersistanceException(Throwable arg0) {
		super(arg0);
	}
	

}
