package com.onboard.web.api.user;

import org.elevenframework.web.interceptor.Interceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onboard.service.account.CompanyService;
import com.onboard.service.security.interceptors.CompanyAdminRequired;
import com.onboard.service.security.interceptors.UserChecking;

/**
 * 删除用户
 * 
 * @author xuchen
 * 
 */
@RequestMapping(value = "/{companyId}/users")
@Controller
public class UserDeleteController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    @Interceptors({ CompanyAdminRequired.class, UserChecking.class })
    public String removeUserFromCompany(@PathVariable int companyId, @PathVariable int userId) {
        companyService.removeUser(companyId, userId);
        return "redirect:/{companyId}/users";
    }

}
