package com.onboard.service.activity;

import com.onboard.domain.model.Activity;
import com.onboard.domain.model.User;
import com.onboard.domain.model.type.BaseProjectItem;

/**
 * 创建完{@link Activity}进行回调的接口，相关的回调是异步完成的
 * 
 * @author yewei
 * 
 */
public interface ActivityHook {

    /**
     * 创建完{@link Activity}时, {@link ActivityRecorder}会调用ActivityHook
     * 
     * @param owner
     *            产生Activity的用户
     * @param activity
     *            被创建出来的Activity
     * @param item
     *            Activity关联的新创建的对象
     * @throws Throwable
     */
    void whenCreationActivityCreated(User owner, Activity activity, BaseProjectItem item) throws Throwable;

    /**
     * 创建完{@link Activity}时, {@link ActivityRecorder}会调用ActivityHook
     * 
     * @param owner
     *            产生Activity的用户
     * @param activity
     *            被创建出来的Activity
     * @param item
     *            Activity关联的更新前的对象，已填充字段
     * @param updatedItem
     *            Activity关联的更新后的对象，已填充字段
     * @throws Throwable
     */
    void whenUpdateActivityCreated(User owner, Activity activity, BaseProjectItem item, BaseProjectItem updatedItem) throws Throwable;
}
