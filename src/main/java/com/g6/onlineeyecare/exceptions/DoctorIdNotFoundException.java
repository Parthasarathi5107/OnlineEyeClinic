package com.g6.onlineeyecare.exceptions;

@SuppressWarnings("serial")
public class DoctorIdNotFoundException extends Exception {
	public DoctorIdNotFoundException() {
		
	}

	public DoctorIdNotFoundException(String message) {
		super(message);
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

}
