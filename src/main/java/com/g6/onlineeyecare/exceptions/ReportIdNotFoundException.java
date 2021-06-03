package com.g6.onlineeyecare.exceptions;

@SuppressWarnings("serial")
public class ReportIdNotFoundException extends Exception {
	public ReportIdNotFoundException() {
		
	}

	public ReportIdNotFoundException(String message) {
		super(message);
	}

	public ReportIdNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public ReportIdNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ReportIdNotFoundException(Throwable cause) {
		super(cause);
		
	}

}
