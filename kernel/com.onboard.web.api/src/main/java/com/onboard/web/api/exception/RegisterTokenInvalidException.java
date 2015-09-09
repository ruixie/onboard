package com.onboard.web.api.exception;

public class RegisterTokenInvalidException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public RegisterTokenInvalidException(String message) {
        super(message);
    }

    public RegisterTokenInvalidException() {
        super();
    }

    public RegisterTokenInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegisterTokenInvalidException(Throwable cause) {
        super(cause);
    }
    
}
