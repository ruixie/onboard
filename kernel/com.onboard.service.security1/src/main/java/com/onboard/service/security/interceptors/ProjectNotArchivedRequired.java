package com.onboard.service.security.interceptors;

import org.springframework.beans.factory.annotation.Autowired;

import com.onboard.domain.model.User;
import com.onboard.service.account.CompanyService;
import com.onboard.service.collaboration.ProjectService;
import com.onboard.service.security.exception.NoPermissionException;

/**
 * @author xuchen
 */
public class ProjectNotArchivedRequired extends BasicIdentifiableInterceptor {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private CompanyService companyService;

    @Override
    public boolean roleCheck(Integer companyId, Integer projectId, User user) {
        if (projectService.getById(projectId).getArchived() || companyService.getById(companyId).getDeleted()) {
            throw new NoPermissionException(companyId);
        }
        return true;
    }

}
