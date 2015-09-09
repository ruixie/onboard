package com.onboard.service.collaboration.notification.rule;

import org.springframework.stereotype.Service;

import com.onboard.domain.model.Activity;
import com.onboard.domain.model.Discussion;
import com.onboard.domain.model.type.Subscribable;
import com.onboard.service.activity.ActivityActionType;
import com.onboard.service.notification.NotificationRule;
import com.onboard.service.notification.SimpleNotificationRule;

/**
 * {@link Discussion}操作需要进行通知的条件，实现为{@link NotificationRule}
 * 
 * @author yewei
 * 
 */
@Service("discussionNotificationRuleBean")
public class DiscussionNotificationRule extends SimpleNotificationRule {

    @Override
    public boolean ifNotify(Activity activity, Subscribable subscribable) {
        return activity.getAction().equals(ActivityActionType.CREATE);

    }

    @Override
    public String modelType() {
        return new Discussion().getType();
    }

}
