package com.onboard.service.collaboration.attach;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.onboard.domain.model.Activity;
import com.onboard.domain.model.type.BaseProjectItem;
import com.onboard.domain.model.type.IdentifiableOperator;
import com.onboard.service.activity.ActivityService;
import com.onboard.service.common.attach.IdentifiableAttachService;

@Service("activityAttachServiceBean")
public class ActivityAttachServiceImpl implements IdentifiableAttachService {

    @Autowired
    ActivityService activityService;

    @Override
    public String attachType() {
        return IdentifiableOperator.NONE_TYPE;
    }

    @Override
    public List<? extends BaseProjectItem> getIdentifiablesByAttachId(int attachId) {
        return Lists.newArrayList();
    }

    @Override
    public String modelType() {
        return new Activity().getType();
    }

    @Override
    public List<? extends BaseProjectItem> getIdentifiablesByAttachId(String attachType, int attachId) {
        return activityService.getByAttachTypeAndId(attachType, attachId);
    }

}
