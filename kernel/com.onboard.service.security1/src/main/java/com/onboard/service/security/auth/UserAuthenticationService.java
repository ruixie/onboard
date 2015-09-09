package com.onboard.service.security.auth;

import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.onboard.domain.model.User;
import com.onboard.service.account.UserService;
import com.onboard.service.web.SessionService;

@Component
public class UserAuthenticationService implements UserDetailsService {
    public static final Logger logger = LoggerFactory.getLogger(UserAuthenticationService.class);

    @Autowired
    private UserService userService;

    @Autowired
    private SessionService session;

    @Override
    public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {

        User user = userService.getUserWithPasswordByEmail(arg0);
        if (user == null) {
            throw new UsernameNotFoundException("User " + arg0 + " Not Found");
        } else {
            session.setCurrentUser(user);
        }

        String salt = user.getCreated().toString();

        return new SaltedUser(arg0, user.getNewPassword(), salt, new HashSet<GrantedAuthority>());
    }
}
