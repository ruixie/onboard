package com.onboard.service.security.interceptors;

import org.springframework.beans.factory.annotation.Autowired;

import com.onboard.domain.model.User;
import com.onboard.domain.model.type.BaseProjectItem;
import com.onboard.service.security.RoleService;

public class DiscussionCreatorRequired extends BasicIdentifiableInterceptor {

    @Autowired
    private RoleService roleService;

    @Override
    public boolean modelCheck(BaseProjectItem identifiable, User user) {
        return identifiable.getCreatorId().equals(user.getId())
                || roleService.projectAdmin(user.getId(), identifiable.getCompanyId(), identifiable.getProjectId());
    }
}
