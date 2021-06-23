package com.g6.onlineeyecare.exceptions;

@SuppressWarnings("serial")
public class UserIdNotFoundException extends Exception {

    final String msg;

	public UserIdNotFoundException() {
		super();
		this.msg = "";
		
		
	}

	public UserIdNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.msg = "";
		
		
	}

	public UserIdNotFoundException(String message, Throwable cause) {
		super(message, cause);
		this.msg = "";
		
		
	}

	public UserIdNotFoundException(String message) {
		super(message);
		this.msg = "";
		
		
	}

	public UserIdNotFoundException(Throwable cause) {
		super(cause);
		this.msg = "";
		
		
	}

	public String getMsg() {
		return msg;
	}
    
    


}
