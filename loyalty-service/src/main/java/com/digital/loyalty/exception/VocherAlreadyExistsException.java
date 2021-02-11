package com.digital.loyalty.exception;

public class VocherAlreadyExistsException extends LoyaltyRewardsGlobalAppException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VocherAlreadyExistsException() {
		super();
	}

	public VocherAlreadyExistsException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public VocherAlreadyExistsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public VocherAlreadyExistsException(String arg0) {
		super(arg0);
	}

	public VocherAlreadyExistsException(Throwable arg0) {
		super(arg0);
	}
	
	

}
