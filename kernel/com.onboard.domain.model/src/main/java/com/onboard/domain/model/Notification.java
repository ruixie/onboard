package com.onboard.domain.model;

import com.onboard.domain.mapper.model.NotificationObject;

/**
 * Domain model: Notification
 * 
 * @generated_by_elevenframework
 * 
 */
public class Notification extends NotificationObject {

    private Activity activity;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Notification() {
        super();
    }

    public Notification(int id) {
        super(id);
    }

    public Notification(NotificationObject obj) {
        super(obj);
    }
}
