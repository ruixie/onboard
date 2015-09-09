package com.onboard.web.api.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.onboard.service.account.UserService;
import com.onboard.web.api.constraints.EmailExists;

public class EmailExistsValidator implements ConstraintValidator<EmailExists, String> {

    public static final Logger logger = LoggerFactory.getLogger(EmailExistsValidator.class);

    @Autowired
    private UserService userService;

    private boolean exist;

    @Override
    public void initialize(EmailExists arg0) {
        this.exist = arg0.exist();
    }

    @Override
    public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
        return !(this.exist ^ userService.isEmailRegistered(arg0));
    }

}
