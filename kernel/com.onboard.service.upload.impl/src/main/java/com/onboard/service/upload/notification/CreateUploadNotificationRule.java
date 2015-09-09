package com.onboard.service.upload.notification;

import org.springframework.stereotype.Service;

import com.onboard.domain.model.Activity;
import com.onboard.domain.model.Upload;
import com.onboard.domain.model.type.Subscribable;
import com.onboard.service.activity.ActivityActionType;
import com.onboard.service.notification.SimpleNotificationRule;

@Service("createUploadNotificationRuleBean")
public class CreateUploadNotificationRule extends SimpleNotificationRule {

    @Override
    public String modelType() {
        return new Upload().getType();
    }

    @Override
    public boolean ifNotify(Activity activity, Subscribable subscribable) {
        return activity.getAction().equals(ActivityActionType.CREATE);
    }

}
