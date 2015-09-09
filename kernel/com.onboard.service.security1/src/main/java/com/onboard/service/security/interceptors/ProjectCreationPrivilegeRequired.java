package com.onboard.service.security.interceptors;

import org.springframework.beans.factory.annotation.Autowired;

import com.onboard.domain.model.User;
import com.onboard.domain.model.type.BaseProjectItem;
import com.onboard.service.security.RoleService;

public class ProjectCreationPrivilegeRequired extends BasicIdentifiableInterceptor {

    @Autowired
    RoleService roleService;

    @Override
    public boolean modelCheck(BaseProjectItem identifiable, User user) {
        return roleService.companyMemberCanCreateProject(user.getId(), identifiable.getCompanyId());
    }

}
