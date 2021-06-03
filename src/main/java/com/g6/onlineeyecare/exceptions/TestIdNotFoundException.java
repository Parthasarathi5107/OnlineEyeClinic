package com.g6.onlineeyecare.exceptions;

@SuppressWarnings("serial")
public class TestIdNotFoundException extends Exception {
	public TestIdNotFoundException() {
		
	}

	public TestIdNotFoundException(String message) {
		super(message);
	}

	public TestIdNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public TestIdNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public TestIdNotFoundException(Throwable cause) {
		super(cause);
		
	}

}
