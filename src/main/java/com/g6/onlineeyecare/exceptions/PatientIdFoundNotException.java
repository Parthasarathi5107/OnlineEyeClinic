package com.g6.onlineeyecare.exceptions;

@SuppressWarnings("serial")
public class PatientIdFoundNotException extends Exception {
	
	private String message;

	public PatientIdFoundNotException() {
		super();
		
	}

	public PatientIdFoundNotException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public PatientIdFoundNotException(String message, Throwable cause) {
		super(message, cause);
		
	}

	

	public PatientIdFoundNotException(Throwable cause) {
		super(cause);
		
	}

	public PatientIdFoundNotException(String message) {
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
