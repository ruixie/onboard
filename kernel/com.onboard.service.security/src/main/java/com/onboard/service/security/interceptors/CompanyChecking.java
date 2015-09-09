package com.onboard.service.security.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.elevenframework.web.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import com.onboard.service.account.CompanyService;
import com.onboard.service.security.utils.SecurityUtils;

public class CompanyChecking extends BasicIdentifiableInterceptor {

    @Autowired
    CompanyService companyService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!super.preHandle(request, response, handler)) {
            return false;
        }

        Integer companyId = SecurityUtils.getIntegerValueOfPathVariable(request, "companyId");
        if (companyId == null || companyId < 0 || companyService.getById(companyId) == null) {
            throw new ResourceNotFoundException();
        }

        return true;
    }
}
