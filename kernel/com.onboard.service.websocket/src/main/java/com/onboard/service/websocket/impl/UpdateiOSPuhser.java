package com.onboard.service.websocket.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

import com.onboard.domain.model.Activity;
import com.onboard.domain.model.User;
import com.onboard.domain.model.type.BaseProjectItem;
import com.onboard.domain.model.type.Subscribable;
import com.onboard.service.activity.ActivityHook;
import com.onboard.service.common.subscrible.SubscriberService;

/**
 * @author xuchen
 * 
 */
@Service("updateIOSPuhserBean")
public class UpdateiOSPuhser implements ActivityHook {

    public static final Logger logger = LoggerFactory.getLogger(UpdateiOSPuhser.class);

    @Autowired
    private JPushClient jpushClient;

    @Autowired
    private SubscriberService subscriberService;

    private void broadcastActivity(Activity activity, BaseProjectItem item) {
        if (item instanceof Subscribable) {
            Subscribable subscribable = (Subscribable) item;
            if (subscribable.getSubscribers() == null || subscribable.getSubscribers().size() == 0) {
                subscriberService.fillSubcribers(subscribable);
            }
            for (User subscriber : subscribable.getSubscribers()) {
                if (subscriber.getId() != null && !subscriber.getId().equals(activity.getCreatorId())) {
                    String pushMessage = activity.getCreatorName() + activity.getSubject() + activity.getTarget();
                    Platform platform = Platform.ios();
                    Audience audience = Audience.alias(subscriber.getId().toString());
                    IosNotification iosNotification = IosNotification.newBuilder().setAlert(pushMessage).autoBadge()
                            .setSound("happy").build();
                    Notification notification = Notification.newBuilder().addPlatformNotification(iosNotification)
                            .build();
                    PushPayload payload = PushPayload.newBuilder().setPlatform(platform).setAudience(audience)
                            .setNotification(notification).build();
                    try {
                        jpushClient.sendPush(payload);
                    } catch (Exception e) {
                        logger.info("Jpush error on ios");
                    }
                }

            }
        }
    }

    @Override
    public void whenCreationActivityCreated(User owner, Activity activity, BaseProjectItem item) throws Throwable {
        broadcastActivity(activity, item);
    }

    @Override
    public void whenUpdateActivityCreated(User owner, Activity activity, BaseProjectItem item, BaseProjectItem updatedItem)
            throws Throwable {
        broadcastActivity(activity, item);
    }

}
