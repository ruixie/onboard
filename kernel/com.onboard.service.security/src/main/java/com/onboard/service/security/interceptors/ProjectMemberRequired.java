package com.onboard.service.security.interceptors;

import org.springframework.beans.factory.annotation.Autowired;

import com.onboard.domain.model.User;
import com.onboard.service.security.RoleService;
import com.onboard.service.security.exception.NoPermissionException;

public class ProjectMemberRequired extends BasicIdentifiableInterceptor {

    @Autowired
    private RoleService roleService;

    @Override
    public boolean roleCheck(Integer companyId, Integer projectId, User user) {

        if (companyId == null || projectId == null) {
            return false;
        }
        if (!roleService.projectMember(user.getId(), companyId, projectId)) {
            throw new NoPermissionException(companyId);
        }

        return true;
    }

}
