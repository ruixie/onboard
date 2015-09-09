package com.onboard.service.common.attach;

import java.util.List;

import com.onboard.domain.model.type.BaseProjectItem;
import com.onboard.domain.model.type.IdentifiableOperator;

/**
 * 获取关联类型集合的服务，可在其中配置关联类型与主体类型的属性
 * 
 * @author XingLiang
 * 
 */
public interface IdentifiableAttachService extends IdentifiableOperator {

    /**
     * 关联类型
     * 
     * @return
     */
    String attachType();

    /**
     * 通过主体类型对象id获取与之相关的所有attachType类型对象
     * 
     * @param attachId
     * @return
     */
    public abstract List<? extends BaseProjectItem> getIdentifiablesByAttachId(int attachId);

    /**
     * 通过主体类型对象id获取与之相关的所有attachType类型对象
     * 
     * @param attachType
     * @param attachId
     * @return
     */
    public abstract List<? extends BaseProjectItem> getIdentifiablesByAttachId(String attachType, int attachId);
}
