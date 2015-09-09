package com.onboard.service.websocket.impl;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onboard.domain.model.Activity;
import com.onboard.domain.model.User;
import com.onboard.domain.model.type.BaseProjectItem;
import com.onboard.service.account.UserService;
import com.onboard.service.activity.ActivityHook;
import com.onboard.service.common.identifiable.IdentifiableManager;
import com.onboard.service.websocket.WebSocketService;

/**
 * @author Gourui
 * 
 */
@Service("updateHTMLPuhserBean")
public class UpdateHTMLPuhser implements ActivityHook {

    public static final Logger logger = LoggerFactory.getLogger(UpdateHTMLPuhser.class);

    @Autowired
    private WebSocketService webSocketService;

    @Autowired
    private IdentifiableManager identifiableManager;

    @Autowired
    private UserService userService;

    private void broadcastByActivity(User owner, Activity activity, BaseProjectItem originalItem, BaseProjectItem updatedItem)
            throws IOException {
        // 为所有项目成员推送HTML更新
        activity.setAttachObject((BaseProjectItem)identifiableManager.getIdentifiableByTypeAndId(activity.getAttachType(), activity.getAttachId()));
        List<User> projectUsers = userService.getUserByProjectId(activity.getProjectId());
        for (User user : projectUsers) {
            if (user.getId() != null) {
                webSocketService.broadcastOne(user.getEmail(), activity);
            }
        }
    }

    @Override
    public void whenCreationActivityCreated(User owner, Activity activity, BaseProjectItem item) throws Throwable {
        broadcastByActivity(owner, activity, item, item);
    }

    @Override
    public void whenUpdateActivityCreated(User owner, Activity activity, BaseProjectItem item, BaseProjectItem updatedItem)
            throws Throwable {
        broadcastByActivity(owner, activity, item, updatedItem);
    }
}
