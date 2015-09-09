package com.onboard.web.api.exception;

public class InvitationTokenInvalidException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public InvitationTokenInvalidException(String message) {
        super(message);
    }

    public InvitationTokenInvalidException() {
        super();
    }

    public InvitationTokenInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvitationTokenInvalidException(Throwable cause) {
        super(cause);
    }
    
}
