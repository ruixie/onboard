package com.onboard.domain.model;

import java.util.Date;
import java.util.List;

import com.onboard.domain.mapper.model.ActivityObject;
import com.onboard.domain.model.type.BaseProjectItem;
import com.onboard.domain.model.type.Recommendable;

/**
 * 领域模型：Activity
 * 
 * @author yewei
 * 
 */
public class Activity extends ActivityObject implements BaseProjectItem, Recommendable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Integer projectColorId;

    private User creator;

    private BaseProjectItem attachObject;

    private List<User> subscribers;

    public BaseProjectItem getAttachObject() {
        return attachObject;
    }

    public void setAttachObject(BaseProjectItem attachObject) {
        this.attachObject = attachObject;
    }

    public Integer getProjectColorId() {
        return projectColorId;
    }

    public void setProjectColorId(Integer projectColorId) {
        this.projectColorId = projectColorId;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Activity() {
        super();
    }

    public Activity(int id) {
        super(id);
    }

    public Activity(ActivityObject obj) {
        super(obj);
    }

    @Override
    public String getType() {
        return "activity";
    }

    public List<User> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<User> subscribers) {
        this.subscribers = subscribers;
    }

    @Override
    public String generateText() {
        return String.format("%s %s", getSubject(), getContent());
    }

    @Override
    public Date getUpdated() {
        return getCreated();
    }

    @Override
    public void setUpdated(Date updated) {
    }

    @Override
    public Boolean getDeleted() {
        return false;
    }

    @Override
    public void setDeleted(Boolean deleted) {
    }

    @Override
    public boolean trashRequried() {
        return false;
    }

}
