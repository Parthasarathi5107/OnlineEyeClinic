package com.g6.onlineeyecare.exceptions;

@SuppressWarnings("serial")
public class AppointmentIdNotFoundException extends Exception {
	public AppointmentIdNotFoundException() {
		
	}

	public AppointmentIdNotFoundException(String message) {
		super(message);
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

}
