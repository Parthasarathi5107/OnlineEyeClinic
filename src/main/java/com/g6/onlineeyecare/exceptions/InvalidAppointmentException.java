package com.g6.onlineeyecare.exceptions;

@SuppressWarnings("serial")
public class InvalidAppointmentException extends Exception {
	public InvalidAppointmentException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidAppointmentException(String message) {
		super(message);
	}

	public InvalidAppointmentException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidAppointmentException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidAppointmentException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
