package com.onboard.domain.model.type;

import java.util.List;

import com.onboard.domain.model.User;

/**
 * 可订阅的对象
 * 
 * @author yewei
 * 
 */
public interface Subscribable extends BaseProjectItem {

    String getSubscribableType();

    Integer getSubscribableId();

    String getSubscribableSubject();

    List<User> getSubscribers();

    void setSubscribers(List<User> users);
}
