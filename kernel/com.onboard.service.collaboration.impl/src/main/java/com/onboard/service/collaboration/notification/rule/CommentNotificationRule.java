package com.onboard.service.collaboration.notification.rule;

import org.springframework.stereotype.Service;

import com.onboard.domain.model.Activity;
import com.onboard.domain.model.Comment;
import com.onboard.domain.model.type.Subscribable;
import com.onboard.service.activity.ActivityActionType;
import com.onboard.service.notification.NotificationRule;
import com.onboard.service.notification.SimpleNotificationRule;

/**
 * {@link Comment}操作需要进行通知的条件，实现为{@link NotificationRule}
 * 
 * @author yewei
 * 
 */
@Service("commentNotificationRuleBean")
public class CommentNotificationRule extends SimpleNotificationRule {

    @Override
    public boolean ifNotify(Activity activity, Subscribable subscribable) {
        return activity.getAction().equals(ActivityActionType.REPLY);
    }

    @Override
    public String modelType() {
        return new Comment().getType();
    }
}
