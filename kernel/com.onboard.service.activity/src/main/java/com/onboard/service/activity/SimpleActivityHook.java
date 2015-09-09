package com.onboard.service.activity;

import com.onboard.domain.model.Activity;
import com.onboard.domain.model.User;
import com.onboard.domain.model.type.BaseProjectItem;

/**
 * 更新操作和新建操作处理逻辑完全一样的{@link ActivityHook}
 * 
 * @author yewei
 *
 */
public abstract class SimpleActivityHook implements ActivityHook {

    @Override
    public abstract void whenCreationActivityCreated(User owner, Activity activity, BaseProjectItem item) throws Throwable;

    @Override
    public void whenUpdateActivityCreated(User owner, Activity activity, BaseProjectItem item, BaseProjectItem updatedItem) throws Throwable {
        whenCreationActivityCreated(owner, activity, updatedItem);
    }

}

