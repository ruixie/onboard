package com.onboard.service.security.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.elevenframework.web.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import com.onboard.domain.model.User;
import com.onboard.service.account.CompanyService;
import com.onboard.service.account.UserService;
import com.onboard.service.security.exception.NoPermissionException;
import com.onboard.service.security.utils.SecurityUtils;

/**
 * 判断user是否存在，以及user是否属于公司
 * 
 * @author yewei
 * 
 */
public class UserChecking extends BasicIdentifiableInterceptor {

    @Autowired
    UserService userService;

    @Autowired
    CompanyService companyService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!super.preHandle(request, response, handler)) {
            return false;
        }

        Integer userId = SecurityUtils.getIntegerValueOfPathVariable(request, "userId");
        User user = userService.getById(userId);
        if (user == null) {
            throw new ResourceNotFoundException();
        }

        Integer companyId = SecurityUtils.getIntegerValueOfPathVariable(request, "companyId");
        if (companyId == null || companyId < 0 || !companyService.containsUser(companyId, userId)) {
            throw new NoPermissionException(companyId);
        }

        return true;
    }
}
