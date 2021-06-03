package com.g6.onlineeyecare.exceptions;

@SuppressWarnings("serial")
public class TestIdNotFoundException extends Exception {
	private String message;
	
	
	
	
	public TestIdNotFoundException(String message) {
		super();
		this.message = message;
		
	}

	public TestIdNotFoundException() {
		
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	

}
