package com.g6.onlineeyecare.exceptions;

@SuppressWarnings("serial")
public class ReportIdNotFoundException extends Exception {

    private String message;



    public ReportIdNotFoundException(String message) {
        super();
        this.message = message;

    }

    public ReportIdNotFoundException() {

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }




}