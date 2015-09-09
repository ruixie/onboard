package com.onboard.web.api.form;

import java.util.List;

import com.onboard.domain.model.User;

public class UploadForm {

    private List<Integer> attachmentIds;

    private List<User> subscribers;

    public List<Integer> getAttachmentIds() {
        return attachmentIds;
    }

    public void setAttachmentIds(List<Integer> attachmentIds) {
        this.attachmentIds = attachmentIds;
    }

    public List<User> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<User> subscribers) {
        this.subscribers = subscribers;
    }

}
