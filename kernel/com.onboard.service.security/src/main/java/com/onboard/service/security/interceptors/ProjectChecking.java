package com.onboard.service.security.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.elevenframework.web.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import com.onboard.domain.model.Project;
import com.onboard.service.collaboration.ProjectService;
import com.onboard.service.security.exception.NoPermissionException;
import com.onboard.service.security.utils.SecurityUtils;

public class ProjectChecking extends BasicIdentifiableInterceptor {

    @Autowired
    ProjectService projectService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!super.preHandle(request, response, handler)) {
            return false;
        }

        Integer projectId = SecurityUtils.getIntegerValueOfPathVariable(request, "projectId");
        Project project = projectService.getById(projectId);
        if (project == null) {
            throw new ResourceNotFoundException();
        }

        Integer companyId = SecurityUtils.getIntegerValueOfPathVariable(request, "companyId");
        if (companyId == null || companyId < 0 || !companyId.equals(project.getCompanyId())) {
            throw new NoPermissionException(companyId);
        }

        return true;
    }
}
