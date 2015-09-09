package com.onboard.service.activity.util;

import org.jsoup.Jsoup;

import com.onboard.domain.model.Activity;
import com.onboard.domain.model.type.BaseProjectItem;
import com.onboard.service.activity.ActivityGenerator;

public class ActivityHelper {

    public static Activity generateActivityByActionType(String actionType,
            String subject, BaseProjectItem item) {
        Activity activity = new Activity();
        activity.setAttachId(item.getId());
        activity.setAttachType(item.getType());

        activity.setSubject(subject);
        activity.setAction(actionType);

        return activity;
    }

    /**
     * 截断Activity内容描述字段
     * 
     * @param str
     * @return
     */
    public static String cutoffActivityContent(String str) {
        if (str != null) {
            return str.substring(0, Math.min(ActivityGenerator.MAX_ACTIVITY_CONTENT_LENGTH, str.length()));
        }
        return null;
    }
 
    /**
     * 截断Activity标题描述字段
     * 
     * @param str
     * @return
     */
    public static String cutoffActivityTitle(String str) {
        if (str != null) {
            return str.substring(0, Math.min(ActivityGenerator.MAX_ACTIVITY_TITLE_LENGTH, str.length()));
        }
        return null;
    }
    
    public static String soup(String content){
        return content == null ? "" : Jsoup.parse(content).text();
    }

}
