package com.onboard.web.api.project;

import org.elevenframework.web.interceptor.Interceptors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onboard.service.security.ProjectPrivilegeService;
import com.onboard.service.security.interceptors.ProjectAdminRequired;

/**
 * Project相关的Controller
 * 
 * @author ruici, yewei
 */
@RequestMapping(value = "/{companyId}/projects")
@Controller
public class ProjectAdminManageController {

    public static final Logger logger = LoggerFactory.getLogger(ProjectAdminManageController.class);

    @Autowired
    private ProjectPrivilegeService projectPrivilegeService;

    @RequestMapping(value = "/{projectId}/admins/{userId}", method = RequestMethod.POST)
    @Interceptors({ ProjectAdminRequired.class })
    public ResponseEntity<Object> addAdminFromProject(@PathVariable("companyId") int companyId,
            @PathVariable("projectId") int projectId, @PathVariable("userId") int userId) {
        projectPrivilegeService.addProjectAdmin(userId, projectId);

        return new ResponseEntity<Object>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{projectId}/admins/{userId}", method = RequestMethod.DELETE)
    @Interceptors({ ProjectAdminRequired.class })
    public ResponseEntity<Object> removeAdminFromProject(@PathVariable int companyId, @PathVariable int projectId,
            @PathVariable int userId) {
        projectPrivilegeService.removeProjectAdmin(userId, projectId);
        return new ResponseEntity<Object>(HttpStatus.CREATED);
    }
}
