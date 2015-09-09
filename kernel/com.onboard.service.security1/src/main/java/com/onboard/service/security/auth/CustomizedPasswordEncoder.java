package com.onboard.service.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.onboard.service.account.UserService;

@Component
public class CustomizedPasswordEncoder implements PasswordEncoder {

    @Autowired
    private UserService userService;

    @Override
    public String encodePassword(String rawPass, Object salt) {
        return userService.createPassword(rawPass, salt.toString());
    }

    @Override
    public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
        return true;
    }

}
