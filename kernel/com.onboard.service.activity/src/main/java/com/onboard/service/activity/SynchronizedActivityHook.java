package com.onboard.service.activity;

import com.onboard.domain.model.Activity;
import com.onboard.domain.model.type.BaseProjectItem;

/**
 * 创建完{@link Activity}进行同步回调的接口
 * 
 * 与{@link ActivityHook}不同的, {@link SynchronizedActivityHook}的回调是同步的
 * 
 * 大部分情况下，应该使用{@link ActivityHook}
 * 
 * 如果使用{@link SynchronizedActivityHook}可能造成请求相应的速度问题
 * 
 * @author yewei
 * 
 */

public interface SynchronizedActivityHook {
    /**
     * 创建完{@link Activity}时, {@link ActivityRecorder}会调用ActivityHook
     * 
     * @param activity
     *            被创建出来的Activity
     * @param item
     *            Activity关联的新创建的对象
     * @throws Throwable
     */
    void whenCreationActivityCreated(Activity activity, BaseProjectItem item) throws Throwable;

    /**
     * 创建完{@link Activity}时, {@link ActivityRecorder}会调用ActivityHook
     * 
     * @param activity
     *            被创建出来的Activity
     * @param item
     *            Activity关联的更新前的对象，已填充字段
     * @param updatedItem
     *            Activity关联的更新后的对象，已填充字段
     * @throws Throwable
     */
    void whenUpdateActivityCreated(Activity activity, BaseProjectItem item, BaseProjectItem updatedItem) throws Throwable;

}
