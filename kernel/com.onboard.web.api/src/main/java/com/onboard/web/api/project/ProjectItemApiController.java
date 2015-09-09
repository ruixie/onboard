package com.onboard.web.api.project;

import org.elevenframework.web.interceptor.Interceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onboard.domain.model.type.ProjectItem;
import com.onboard.service.collaboration.IdInProjectService;
import com.onboard.service.security.interceptors.ProjectChecking;
import com.onboard.service.security.interceptors.ProjectMemberRequired;

@RequestMapping(value = "/{companyId}/projects/{projectId}/projectItem")
@Controller
public class ProjectItemApiController {

    @Autowired
    private IdInProjectService idInProjectService;

    @RequestMapping(value = "/{projectItemId}", method = RequestMethod.GET)
    @Interceptors({ ProjectMemberRequired.class, ProjectChecking.class })
    @ResponseBody
    public ProjectItem getProjectItemByProject(@PathVariable("projectId") int projectId,
            @PathVariable("projectItemId") int projectItemId) {
        return idInProjectService.get(projectId, projectItemId);
    }
}
