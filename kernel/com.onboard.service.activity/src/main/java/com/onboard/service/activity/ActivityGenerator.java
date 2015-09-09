package com.onboard.service.activity;

import com.onboard.domain.model.Activity;
import com.onboard.domain.model.type.BaseProjectItem;
import com.onboard.domain.model.type.IdentifiableOperator;

/**
 * 生成{@link Activity}信息的接口
 * 
 * @author yewei
 * 
 */
public interface ActivityGenerator extends IdentifiableOperator {

    public int MAX_ACTIVITY_CONTENT_LENGTH = 200;

    public int MAX_ACTIVITY_TITLE_LENGTH = 100;

    /**
     * 对model进行操作的服务,该服务相关方法产生活动 ，可用于删除时生将Service与ModelType对照
     * 
     * @return
     */
    String modelService();

    /**
     * 填充对象详细信息，特定的实现通常只需要根据id从数据库中进行查询即可
     * 
     * @param identifiable
     * @return 填充过的对象，需要一个新的对象，不是缓存中的
     */
    BaseProjectItem enrichModel(BaseProjectItem identifiable);

    /**
     * 生成创建对象时产生的活动信息
     * 
     * @param item
     * @return 活动信息
     */
    Activity generateCreateActivity(BaseProjectItem item);

    /**
     * 生成更新对象时产生的活动信息
     * 
     * @param item
     * @param modifiedItem
     * @return 活动信息
     */
    Activity generateUpdateActivity(BaseProjectItem item, BaseProjectItem modifiedItem);
}
