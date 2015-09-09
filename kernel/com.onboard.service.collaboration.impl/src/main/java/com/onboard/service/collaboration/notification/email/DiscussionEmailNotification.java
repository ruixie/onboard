package com.onboard.service.collaboration.notification.email;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.onboard.domain.model.Activity;
import com.onboard.domain.model.Discussion;
import com.onboard.domain.model.Project;
import com.onboard.domain.model.type.Subscribable;
import com.onboard.service.collaboration.ProjectService;
import com.onboard.service.notification.NotificationMethod;
import com.onboard.service.notification.NotificationRule;
import com.onboard.service.notification.email.AbstractEmailNotification;

/**
 * 针对{@link Discussion}实现的{@link NotificationMethod}
 * 
 * @author XR, yewei
 * 
 */

@Service("discussionEmailNotificationBean")
public class DiscussionEmailNotification extends AbstractEmailNotification {

    private static final String VM_NAME = "discussion-created.vm";

    @Autowired
    @Qualifier("discussionNotificationRuleBean")
    private NotificationRule notificationRule;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmailNotificationHelper emailNotificationHelper;

    @Override
    public String getEmailSubject(Activity activity, Subscribable item) {
        Discussion discussion = (Discussion) item;
        return subjectInSpecificProject(activity, item, discussion.getSubject());
    }

    @Override
    public String getTemplatePath() {
        return VM_PATH + VM_NAME;
    }

    @Override
    public NotificationRule getNotificationRule() {
        return this.notificationRule;
    }

    @Override
    public String modelType() {
        return new Discussion().getType();
    }

    @Override
    public Map<String, Object> getModel(Activity activity, Subscribable item, Map<String, Object> model) {
        Discussion discussion = (Discussion) item;
        Project project = this.projectService.getById(discussion.getProjectId());
        model.put("userName", this.getOwner(activity).getName());
        model.put("projectName", project.getName());
        model.put("subject", discussion.getSubject());
        model.put("content", discussion.getContent());
        model.put("attachmentList", emailNotificationHelper.getAttachementListEmailContent(discussion.getAttachments(),
                discussion.getCompanyId(), discussion.getProjectId()));

        return model;
    }

}
