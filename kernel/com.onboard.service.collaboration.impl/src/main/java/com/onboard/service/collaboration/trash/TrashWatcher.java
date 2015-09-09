package com.onboard.service.collaboration.trash;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onboard.domain.model.Activity;
import com.onboard.domain.model.Trash;
import com.onboard.domain.model.User;
import com.onboard.domain.model.type.BaseProjectItem;
import com.onboard.service.activity.ActivityHook;
import com.onboard.service.collaboration.TrashService;

/**
 * @author Gourui
 * 
 */
@Service("trashWatcherBean")
public class TrashWatcher implements ActivityHook {

    public static final Logger logger = LoggerFactory.getLogger(TrashWatcher.class);

    @Autowired
    private TrashService trashService;

    @Override
    public void whenUpdateActivityCreated(User owner, Activity activity, BaseProjectItem item, BaseProjectItem updatedItem)
            throws Throwable {
        if (updatedItem.getDeleted() && !item.getDeleted()) {
            Trash trash = new Trash();
            trash.setAttachId(item.getId());
            trash.setCompanyId(item.getCompanyId());
            trash.setProjectId(item.getProjectId());
            trash.setAttachType(item.getType());
            trash.setDeletedTime(new Date());
            trashService.addTrash(trash);
        } else if (!updatedItem.getDeleted() && item.getDeleted()) {
            Trash trash = new Trash();
            trash.setAttachId(item.getId());
            trash.setCompanyId(item.getCompanyId());
            trash.setProjectId(item.getProjectId());
            trash.setAttachType(item.getType());
            trashService.deleteTrashByExample(trash);
        }
    }

    @Override
    public void whenCreationActivityCreated(User owner, Activity activity, BaseProjectItem item) throws Throwable {

    }
}
