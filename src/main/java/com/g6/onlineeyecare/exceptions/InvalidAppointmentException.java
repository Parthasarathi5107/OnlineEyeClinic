package com.g6.onlineeyecare.exceptions;

@SuppressWarnings("serial")
public class InvalidAppointmentException extends Exception {
	public InvalidAppointmentException() {
		
	}

	public InvalidAppointmentException(String message) {
		super(message);
	}

	public InvalidAppointmentException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public InvalidAppointmentException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public InvalidAppointmentException(Throwable cause) {
		super(cause);
		
	}

}
