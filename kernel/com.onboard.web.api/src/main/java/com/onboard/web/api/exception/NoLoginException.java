package com.onboard.web.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class NoLoginException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 2032023852294088904L;

    public NoLoginException() {

    }

    public NoLoginException(RuntimeException runtimeException) {
        super(runtimeException);
    }

    public NoLoginException(String message) {
        super(message);
    }
}
