package com.onboard.web.api.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.onboard.service.account.UserService;
import com.onboard.service.web.SessionService;
import com.onboard.web.api.constraints.UsernameExists;

public class UsernameExistsValidator implements ConstraintValidator<UsernameExists, String> {

    public static final Logger logger = LoggerFactory.getLogger(EmailExistsValidator.class);

    @Autowired
    private UserService userService;

    @Autowired
    private SessionService sessionService;

    private boolean exist;

    @Override
    public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
        String currentUserUsername = sessionService.getCurrentUser().getUsername();
        if (currentUserUsername != null && arg0.equals(currentUserUsername)) {
            return true;
        }
        return !(this.exist ^ userService.containUsername(arg0));
    }

    @Override
    public void initialize(UsernameExists constraintAnnotation) {
        this.exist = constraintAnnotation.exist();
    }
}
