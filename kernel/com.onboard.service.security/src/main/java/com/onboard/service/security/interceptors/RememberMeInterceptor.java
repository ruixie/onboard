package com.onboard.service.security.interceptors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.onboard.domain.model.User;
import com.onboard.service.account.UserService;
import com.onboard.service.web.SessionService;

/**
 * 每次请求前检查是否已经Remember Me功能生成的Cookie，如果存在且用户并未登陆，则自动登陆之
 * 
 * @author Ruici
 * 
 */

public class RememberMeInterceptor extends HandlerInterceptorAdapter {

    public static final String COOKIE_UID = "uid";

    public static final String COOKIE_TOKEN = "rmtk";

    @Autowired
    private SessionService session;

    @Autowired
    private UserService userService;

    public static final Logger logger = LoggerFactory.getLogger(RememberMeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();
        if (!path.startsWith("/static/") && !path.equals("/favicon.ico")) {
            Cookie[] cookies = ((HttpServletRequest) request).getCookies();
            if (!ObjectUtils.isEmpty(cookies)) {
                int uid = 0;
                String token = null;
                for (Cookie cookie : cookies) {
                    if (COOKIE_UID.equals(cookie.getName())) {
                        uid = Integer.parseInt(cookie.getValue());
                    }
                    if (COOKIE_TOKEN.equals(cookie.getName())) {
                        token = cookie.getValue();
                    }
                }
                User user = userService.authenticateRememberMeToken(uid, token);
                if (user != null) {
                    session.setCurrentUser(user);
                }
            }
        }
        return super.preHandle(request, response, handler);
    }

}
