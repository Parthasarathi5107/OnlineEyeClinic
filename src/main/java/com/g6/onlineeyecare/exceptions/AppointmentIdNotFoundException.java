package com.g6.onlineeyecare.exceptions;

@SuppressWarnings("serial")
public class AppointmentIdNotFoundException extends Exception {
	public AppointmentIdNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public AppointmentIdNotFoundException(String message) {
		super(message);
	}

	public AppointmentIdNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public AppointmentIdNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AppointmentIdNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
