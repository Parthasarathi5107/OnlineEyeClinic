package com.g6.onlineeyecare.exceptions;

@SuppressWarnings("serial")
public class UserIdNotFoundException extends Exception {

	public UserIdNotFoundException() {
		super();
		
	}

	public UserIdNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public UserIdNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public UserIdNotFoundException(String message) {
		super(message);
		
	}

	public UserIdNotFoundException(Throwable cause) {
		super(cause);
		
	}

}
