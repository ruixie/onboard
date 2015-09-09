package com.onboard.service.notification;

import com.onboard.domain.model.Activity;
import com.onboard.domain.model.type.Subscribable;

public abstract class SimpleNotificationMethod implements NotificationMethod {

    @Override
    public void notifySubsribers(Activity activity, Subscribable item) {
        // 什么都不干，由继承者自己实现
        return;
    }

    @Override
    public void notifySubsribers(Activity activity, Subscribable original, Subscribable updated) {
        notifySubsribers(activity, updated);
    }

}
