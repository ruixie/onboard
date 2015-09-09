package com.onboard.domain.model;

import com.onboard.domain.mapper.model.SubscriberObject;
import com.onboard.domain.model.type.Typeable;

/**
 * 领域模型：Subscriber
 * 
 * @author yewei
 * 
 */
public class Subscriber extends SubscriberObject implements Typeable {

    public Subscriber() {
        super();
    }

    public Subscriber(int id) {
        super(id);
    }

    public Subscriber(SubscriberObject obj) {
        super(obj);
    }

    @Override
    public String getType() {
        return "subscriber";
    }

}
