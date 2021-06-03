package com.g6.onlineeyecare.exceptions;

@SuppressWarnings("serial")
public class DoctorIdNotFoundException extends Exception {
	
	private String message;

	public DoctorIdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public DoctorIdNotFoundException() {
		super();
		
	}

	public DoctorIdNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public DoctorIdNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public DoctorIdNotFoundException(Throwable cause) {
		super(cause);
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
