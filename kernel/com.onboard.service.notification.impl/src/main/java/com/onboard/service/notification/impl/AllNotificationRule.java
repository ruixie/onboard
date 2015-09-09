package com.onboard.service.notification.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.onboard.domain.model.Activity;
import com.onboard.domain.model.type.IdentifiableOperator;
import com.onboard.domain.model.type.Subscribable;
import com.onboard.service.notification.NotificationRule;

/**
 * 环境中所有{@link NotificationRule}
 * 
 * @author XR
 * 
 */
@Service("allNotificationRuleBean")
public class AllNotificationRule implements NotificationRule {

    private static final Map<String, ArrayList<NotificationRule>> notificationRules = Collections
            .synchronizedMap(new HashMap<String, ArrayList<NotificationRule>>());

    public synchronized void addNotificationRule(NotificationRule rule) {
        if (rule != null) {
            ArrayList<NotificationRule> rules = notificationRules.get(rule.modelType());
            if (rules == null) {
                rules = new ArrayList<NotificationRule>();
            }
            rules.add(rule);
            notificationRules.put(rule.modelType(), rules);
        }
    }

    public synchronized void removeNotificationRule(NotificationRule rule) {
        if (rule != null) {
            ArrayList<NotificationRule> rules = notificationRules.get(rule.modelType());
            if (rules != null) {
                rules.remove(rule);
            }
        }
    }

    @Override
    public String modelType() {
        return IdentifiableOperator.NONE_TYPE;
    }

    @Override
    public boolean ifNotify(Activity activity, Subscribable subscribable) {
        return this.ifNotify(activity, subscribable, null);
    }

    @Override
    public boolean ifNotify(Activity activity, Subscribable original, Subscribable updated) {
        List<NotificationRule> rules = notificationRules.get(original.getType());
        if (rules != null) {
            for (NotificationRule rule : rules) {
                if (updated == null) {
                    if (rule.ifNotify(activity, original)) {
                        return true;
                    }
                } else if (rule.ifNotify(activity, original, updated)) {
                    return true;
                }
            }
        }
        return false;
    }
}
