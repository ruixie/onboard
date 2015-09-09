package com.onboard.service.collaboration.attach;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onboard.domain.model.Activity;
import com.onboard.domain.model.Todo;
import com.onboard.domain.model.type.BaseProjectItem;
import com.onboard.service.activity.ActivityService;
import com.onboard.service.common.attach.AbstractAttachService;
import com.onboard.service.common.attach.IdentifiableAttachService;

/**
 * {@link IdentifiableAttachService} Todo与Activity关联服务实现
 * 
 * @author XingLiang
 * 
 */
@Service("todoActivityAttachServiceBean")
public class TodoActivityAttachServiceImpl extends AbstractAttachService {

    @Autowired
    ActivityService activityService;

    @Override
    public String attachType() {
        return new Todo().getType();
    }

    @Override
    public List<? extends BaseProjectItem> getIdentifiablesByAttachId(int attachId) {
        return activityService.getByTodo(attachId, 0, -1);
    }

    @Override
    public String modelType() {
        return new Activity().getType();
    }

}
