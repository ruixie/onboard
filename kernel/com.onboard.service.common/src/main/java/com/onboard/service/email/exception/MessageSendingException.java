package com.onboard.service.email.exception;

public class MessageSendingException extends Exception {

    private static final long serialVersionUID = 2806315663721714620L;
    
    public MessageSendingException(){
        super();
    }
    
    public MessageSendingException(Throwable t){
        this.initCause(t);
    }

}
