package com.g6.onlineeyecare.exceptions;

@SuppressWarnings("serial")
public class InvalidAppointmentException extends Exception {
	
	private String message;

	public InvalidAppointmentException(String message) {
		super();
		this.message = message;
	}

	public InvalidAppointmentException() {
		super();
		
	}

	public InvalidAppointmentException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	
	}

	public InvalidAppointmentException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	
	}

	public InvalidAppointmentException(Throwable arg0) {
		super(arg0);
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	

	
	
	

	

}
