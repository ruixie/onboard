package com.onboard.service.collaboration.notification.rule;

import org.springframework.stereotype.Service;

import com.onboard.domain.model.Activity;
import com.onboard.domain.model.Todo;
import com.onboard.domain.model.IterationItemStatus;
import com.onboard.domain.model.type.Subscribable;
import com.onboard.service.notification.NotificationRule;
import com.onboard.service.notification.SimpleNotificationRule;

/**
 * 表示{@link Todo}完成对应的{@link NotificationRule}
 * 
 * @author yewei
 * 
 */
@Service("completedTodoNotificationRuleBean")
public class CompletedTodoNotificationRule extends SimpleNotificationRule {

    @Override
    public boolean ifNotify(Activity activity, Subscribable subscribable) {
        return activity.getAction().equals(IterationItemStatus.CLOSED);
    }

    @Override
    public String modelType() {
        return new Todo().getType();
    }

}
