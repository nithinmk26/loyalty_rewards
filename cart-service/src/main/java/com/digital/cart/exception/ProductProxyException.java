package com.digital.cart.exception;

public class ProductProxyException extends LoyaltyRewardsGlobalAppException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductProxyException() {
	}

	public ProductProxyException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public ProductProxyException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ProductProxyException(String arg0) {
		super(arg0);
	}

	public ProductProxyException(Throwable arg0) {
		super(arg0);
	}

}
