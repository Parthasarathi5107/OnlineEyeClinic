package com.g6.onlineeyecare.exceptions;

@SuppressWarnings("serial")
public class PatientIdFoundNotException extends Exception {
	public PatientIdFoundNotException() {
		
	}

	public PatientIdFoundNotException(String message) {
		super(message);
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

}
