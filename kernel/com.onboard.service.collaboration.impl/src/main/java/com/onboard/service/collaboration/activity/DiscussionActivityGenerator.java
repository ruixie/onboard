package com.onboard.service.collaboration.activity;

import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onboard.domain.model.Activity;
import com.onboard.domain.model.Discussion;
import com.onboard.domain.model.type.BaseProjectItem;
import com.onboard.service.activity.ActivityActionType;
import com.onboard.service.activity.ActivityGenerator;
import com.onboard.service.activity.util.ActivityHelper;
import com.onboard.service.collaboration.DiscussionService;

/**
 * 生成讨论相关活动信息的辅助类
 * 
 * @author yewei
 * 
 */
@Service("discussionActivityGeneratorBean")
public class DiscussionActivityGenerator implements ActivityGenerator {

    @Autowired
    private DiscussionService discussionService;

    public static final String CREATE_SUBJECT = "发起了讨论";
    public static final String DISCARD_SUBJECT = "删除了讨论";
    public static final String RECOVER_SUBJECT = "从回收站还原了讨论";
    public static final String MOVE_SUBJECT = "移动了讨论";
    public static final String UPDATE_SUBJECT = "更新了讨论";

    private Activity generateActivityByActionType(String actionType, String subject, Discussion discussion) {

        Activity activity = ActivityRecorderHelper.generateActivityByActionType(actionType, subject, discussion);

        activity.setTarget(discussion.getSubject());
        activity.setContent(ActivityHelper.cutoffActivityContent(Jsoup.parse(discussion.getContent()).text()));

        activity.setProjectId(discussion.getProjectId());
        activity.setCompanyId(discussion.getCompanyId());

        return activity;

    }

    private Activity generateUpdateActivity(Discussion discussion, Discussion modifiedDicussion) {
        if (!discussion.getProjectId().equals(modifiedDicussion.getProjectId())) {
            Activity activity = this.generateActivityByActionType(ActivityActionType.MOVE, MOVE_SUBJECT, discussion);

            ActivityRecorderHelper.setupMoveInformation(discussion.getProjectId(), modifiedDicussion.getProjectId(), activity);

            return activity;
        }

        Activity activity = this.generateActivityByActionType(ActivityActionType.UPDATE, UPDATE_SUBJECT, discussion);

        return activity;
    }

    @Override
    public String modelType() {
        return new Discussion().getType();
    }

    @Override
    public Activity generateCreateActivity(BaseProjectItem item) {

        Discussion discussion = (Discussion) item;

        return this.generateActivityByActionType(ActivityActionType.CREATE, CREATE_SUBJECT, discussion);
    }

    @Override
    public Activity generateUpdateActivity(BaseProjectItem item, BaseProjectItem modifiedItem) {
        Discussion d1 = (Discussion) item;
        Discussion d2 = (Discussion) modifiedItem;

        if (d2.getDeleted() != null && d1.getDeleted() != d2.getDeleted()) {
            if (d2.getDeleted()) {
                return this.generateActivityByActionType(ActivityActionType.DISCARD, DISCARD_SUBJECT, d1);
            } else {
                return this.generateActivityByActionType(ActivityActionType.RECOVER, RECOVER_SUBJECT, d1);
            }
        } else {
            return this.generateUpdateActivity(d1, d2);
        }
    }

    @Override
    public BaseProjectItem enrichModel(BaseProjectItem identifiable) {
        return new Discussion(discussionService.getById(identifiable.getId()));
    }

    @Override
    public String modelService() {
        return DiscussionService.class.getName();
    }

}
