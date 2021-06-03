package com.g6.onlineeyecare.exceptions;

@SuppressWarnings("serial")
public class SpectaclesIdNotFoundException extends Exception{
	
	private String message;
	
	

	
	public SpectaclesIdNotFoundException(String message) {
		super();
		this.message = message;
		
	}

	public SpectaclesIdNotFoundException() {
		super();
		
	}

	public SpectaclesIdNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public SpectaclesIdNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	

	public SpectaclesIdNotFoundException(Throwable cause) {
		super(cause);
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
