package com.g6.onlineeyecare.exceptions;

@SuppressWarnings("serial")
public class UserIdNotFoundException extends Exception {

    private String message;




    public UserIdNotFoundException(String message) {
        super();
        this.message = message;

    }

    public UserIdNotFoundException() {
        super();

    }

    public UserIdNotFoundException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);

    }

    public UserIdNotFoundException(String message, Throwable cause) {
        super(message, cause);

    }



    public UserIdNotFoundException(Throwable cause) {
        super(cause);

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }




}
