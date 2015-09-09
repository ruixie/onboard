package com.onboard.service.email.exception;

public class AddressInvalidException extends Exception {

    private static final long serialVersionUID = -5093112500547107498L;

    public AddressInvalidException(String address){
        super("EmailAddress:" + address + " is invalid.");
    }
}
