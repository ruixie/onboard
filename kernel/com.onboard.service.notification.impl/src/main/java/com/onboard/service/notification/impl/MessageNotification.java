package com.onboard.service.notification.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.onboard.domain.mapper.model.NotificationExample;
import com.onboard.domain.model.Activity;
import com.onboard.domain.model.Notification;
import com.onboard.domain.model.User;
import com.onboard.domain.model.type.Subscribable;
import com.onboard.service.activity.ActivityService;
import com.onboard.service.common.subscrible.SubscriberService;
import com.onboard.service.notification.NotificationMethod;
import com.onboard.service.notification.NotificationRule;
import com.onboard.service.notification.NotificationService;
import com.onboard.service.notification.SimpleNotificationMethod;

/**
 * 站内消息提醒的实现
 * 
 * @author XR, yewei
 * 
 */
@Service("messageNotificationBean")
public class MessageNotification extends SimpleNotificationMethod {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private SubscriberService subscriberService;

    @Autowired
    @Qualifier("allNotificationRuleBean")
    private NotificationRule notificationRule;

    /**
     * 填充notifications信息
     * 
     * @param activity
     * @param user
     * @return
     */
    private Notification enrichNotificaton(Activity activity, User user) {
        Notification notification = new Notification();
        notification.setIsRead(false);
        notification.setUserId(user.getId());
        notification.setCompanyId(activity.getCompanyId());
        notification.setActivityId(activity.getId());
        notification.setCreated(activity.getCreated());
        return notification;
    }

    /**
     * 根据activity和user信息新建或更新notification信息
     * 
     * @param activity
     * @param user
     * @return
     */
    private Notification generateMessageNotificationByActivityAndUser(Activity activity, User user) {
        Notification notification = this.enrichNotificaton(activity, user);

        // 若是本人操作,则将notification设为已读，即不发送通知提醒
        if (user.getId().equals(activity.getCreatorId())) {
            notification.setIsRead(true);
        }

        // 根据activitys.size判断之前是否已经发送过有关该对象的通知，若已发送，则更新通知，若未发送，则新建通知
        List<Activity> activities = activityService.getByAttachTypeAndId(activity.getAttachType(),
                activity.getAttachId());
        if (activities.size() == 1) {
            notificationService.createNotification(notification);
            return notification;
        }

        // 通过activityId和userId找到之前的通知，若找到则更新之，若未找到，则创建之
        List<Integer> activityIds = new ArrayList<Integer>();
        for (Activity a : activities) {
            activityIds.add(a.getId());
        }
        Notification sample = new Notification();
        sample.setUserId(user.getId());
        NotificationExample example = new NotificationExample(sample);
        example.getOredCriteria().get(0).andActivityIdIn(activityIds);
        example.setLimit(0, -1);
        List<Notification> ns = notificationService.getNotificationsByExample(example);
        if (ns == null || ns.size() == 0) {
            notificationService.createNotification(notification);
        } else {
            notification.setId(ns.get(0).getId());
            notificationService.updateNotification(notification);
        }
        return notification;
    }

    @Override
    public String modelType() {
        return NotificationMethod.NONE_TYPE;
    }

    @Override
    public void notifySubsribers(Activity activity, Subscribable item) {
        subscriberService.fillSubcribers(item);
        for (User subscriber : item.getSubscribers()) {
            this.generateMessageNotificationByActivityAndUser(activity, subscriber);
        }
    }

    @Override
    public NotificationRule getNotificationRule() {
        return this.notificationRule;
    }

}
