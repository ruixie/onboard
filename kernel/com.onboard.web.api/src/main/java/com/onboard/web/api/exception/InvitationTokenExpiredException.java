package com.onboard.web.api.exception;

public class InvitationTokenExpiredException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public InvitationTokenExpiredException(String message) {
        super(message);
    }

    public InvitationTokenExpiredException() {
        super();
    }

    public InvitationTokenExpiredException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvitationTokenExpiredException(Throwable cause) {
        super(cause);
    }
    
}
