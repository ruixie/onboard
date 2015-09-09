package com.onboard.service.security.interceptors;

import org.springframework.beans.factory.annotation.Autowired;

import com.onboard.domain.model.User;
import com.onboard.service.security.RoleService;
import com.onboard.service.security.exception.NoPermissionException;

public class CompanyMemberRequired extends BasicIdentifiableInterceptor {

    @Autowired
    private RoleService roleService;

    public boolean roleCheck(Integer companyId, Integer projectId, User user) {
        if (companyId == null) {
            return false;
        }

        if (!roleService.companyMember(user.getId(), companyId)) {
            throw new NoPermissionException(companyId);
        }

        return true;
    }
}
