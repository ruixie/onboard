package com.onboard.service.common.attach;

import java.util.List;

import com.onboard.domain.model.type.BaseProjectItem;

/**
 * 根据主体类型获取关联类型集合的服务，关系需要在Kernel中经过注册
 * 
 * @author XingLiang
 * 
 */
public interface IdentifiableAttachManager {

    /**
     * 根据attachType和attachId获取type类型的相关对象 ，例如根据{todo}和{todoId}获取所有相关的Comments
     * 
     * @param type
     * @param attachType
     * @param attachId
     * @return
     */
    public List<? extends BaseProjectItem> getIdentifiablesByTypeAndAttachTypeAndId(String type, String attachType, Integer attachId);

}
