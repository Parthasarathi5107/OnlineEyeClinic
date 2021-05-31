package com.g6.onlineeyecare.exceptions;

@SuppressWarnings("serial")
public class DoctorIdNotFoundException extends Exception {
	public DoctorIdNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public DoctorIdNotFoundException(String message) {
		super(message);
	}

	public DoctorIdNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DoctorIdNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DoctorIdNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
