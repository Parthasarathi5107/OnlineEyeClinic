package com.g6.onlineeyecare.exceptions;

@SuppressWarnings("serial")
public class AppointmentIdNotFoundException extends Exception {
	
	private String message;

	public AppointmentIdNotFoundException() {
		super();
		
	}

	public AppointmentIdNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public AppointmentIdNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	

	public AppointmentIdNotFoundException(Throwable cause) {
		super(cause);
		
	}

	public AppointmentIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	
	
	
}