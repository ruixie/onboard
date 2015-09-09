package com.onboard.web.api.exception;

public class ResetPasswordTokenInvalidException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ResetPasswordTokenInvalidException(String message) {
        super(message);
    }

    public ResetPasswordTokenInvalidException() {
        super();
    }

    public ResetPasswordTokenInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResetPasswordTokenInvalidException(Throwable cause) {
        super(cause);
    }
    
}
