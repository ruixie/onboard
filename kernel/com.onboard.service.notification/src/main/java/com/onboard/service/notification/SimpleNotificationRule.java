package com.onboard.service.notification;

import com.onboard.domain.model.Activity;
import com.onboard.domain.model.type.Subscribable;

public abstract class SimpleNotificationRule implements NotificationRule {

    @Override
    public boolean ifNotify(Activity activity, Subscribable subscribable) {
        return false;
    }

    @Override
    public boolean ifNotify(Activity activity, Subscribable original, Subscribable updated) {
        return ifNotify(activity, updated);
    }

}
