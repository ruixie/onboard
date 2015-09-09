package com.onboard.web.api.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.onboard.web.api.constraints.Username;

public class UsernameValidator implements ConstraintValidator<Username, String> {

    @Override
    public void initialize(Username constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.length() == 0) {
            return true;
        }
        return value.matches("^[a-zA-Z0-9_]{3,16}$");
    }

}
