package com.onboard.service.security.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.onboard.service.security.exception.NoPermissionException;
import com.onboard.service.web.SessionService;

/**
 * 判断是否是管理员的 Interceptor
 * 
 * @author txq
 * 
 */
public class ManagerRequired extends HandlerInterceptorAdapter {

    @Autowired
    protected SessionService session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!session.getCurrentUser().getIsManager()) {
            throw new NoPermissionException("403");
        }
        return true;
    }
}
