package com.onboard.service.activity.exception;

public class ActivityRecorderException extends Exception {

    private static final long serialVersionUID = 1L;

    public ActivityRecorderException(String message) {
        super(message);
    }

    public ActivityRecorderException(String message, Throwable cause) {
        super(message, cause);
    }

}
