package com.digital.cart.exception;

public class CartPersistingException extends LoyaltyRewardsGlobalAppException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CartPersistingException() {
		super();
	}

	public CartPersistingException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public CartPersistingException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CartPersistingException(String arg0) {
		super(arg0);
	}

	public CartPersistingException(Throwable arg0) {
		super(arg0);
	}
	
	

}
