package com.onboard.service.notification;

import com.onboard.domain.model.Activity;
import com.onboard.domain.model.type.IdentifiableOperator;
import com.onboard.domain.model.type.Subscribable;

/**
 * 代表一类提醒方法，如站内提醒或者邮件提醒
 * 
 * @author yewei
 * 
 */
public interface NotificationMethod extends IdentifiableOperator {

    NotificationRule getNotificationRule();

    void notifySubsribers(Activity activity, Subscribable item);

    void notifySubsribers(Activity activity, Subscribable original, Subscribable updated);
}
