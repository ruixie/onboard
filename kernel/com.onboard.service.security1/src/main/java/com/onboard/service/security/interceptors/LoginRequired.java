package com.onboard.service.security.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.onboard.service.web.SessionService;

/**
 * 判断是否登录的Spring MVC Interceptor
 * 
 * @author SERC
 * 
 */
public class LoginRequired extends HandlerInterceptorAdapter {

    @Autowired
    protected SessionService session;

    public static final Logger logger = LoggerFactory.getLogger(LoginRequired.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (session.getCurrentUser() == null) {
            if (request.getRequestURI().startsWith("/api")) {
                response.setContentType("application/json;charset=UTF-8");
                String status = "{\"status\" : \"loginRequired\",";
                status += "\"next\":" + "\"/account/signin?next=" + request.getHeader("Referer") + "\"}";
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                response.getWriter().write(status);
                response.getWriter().flush();
            } else {
                response.sendRedirect("/account/signin?next=" + request.getRequestURL().toString());
            }
            return false;
        }

        return super.preHandle(request, response, handler);
    }
}
