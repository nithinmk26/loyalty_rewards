package com.digital.loyalty.exception;

public class VocherAlreadyUtilizedException extends LoyaltyRewardsGlobalAppException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VocherAlreadyUtilizedException() {
		super();
	}

	public VocherAlreadyUtilizedException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public VocherAlreadyUtilizedException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public VocherAlreadyUtilizedException(String arg0) {
		super(arg0);
	}

	public VocherAlreadyUtilizedException(Throwable arg0) {
		super(arg0);
	}

	
	
}
