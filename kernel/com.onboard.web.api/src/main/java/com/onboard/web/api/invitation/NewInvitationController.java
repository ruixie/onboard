package com.onboard.web.api.invitation;

import java.util.ArrayList;
import java.util.List;

import org.elevenframework.web.interceptor.Interceptors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onboard.domain.model.Project;
import com.onboard.service.account.AccountService;
import com.onboard.service.collaboration.ProjectService;
import com.onboard.service.security.interceptors.InvitationPermissionRequired;
import com.onboard.web.api.form.InvitationForm;

@Controller
@RequestMapping("/{companyId}/invitations")
@Interceptors({ InvitationPermissionRequired.class })
public class NewInvitationController {

    public static final Logger logger = LoggerFactory.getLogger(NewInvitationController.class);

    @Autowired
    ProjectService projectService;

    @Autowired
    AccountService accountService;

    @Autowired
    private Validator validator;

    @InitBinder
    protected void initRegistrationBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Void> invitePeople(@PathVariable int companyId, @RequestBody InvitationForm form) {
        List<Project> projects = new ArrayList<Project>();
        if (form.getProjectIdList() != null) {
            for (Integer projectId : form.getProjectIdList()) {
                Project project = projectService.getById(projectId);
                if (project != null) {
                    projects.add(project);
                }
            }
        }

        for (String email : form.getEmailAddresses()) {
            if (email == null || email.isEmpty()) {
                continue;
            }
            logger.debug("email = {}", email);
            accountService.sendInvitation(companyId, email, projects);
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
