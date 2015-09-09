package com.onboard.service.common.identifiable;

import com.onboard.domain.mapper.model.common.BaseExample;
import com.onboard.domain.model.type.BaseOperateItem;
import com.onboard.service.base.BaseService;

/**
 * 根据类型和Id获取对象实例的服务，对象需要在Kernel中经过注册
 * 
 * @author yewei
 * 
 */

public interface IdentifiableManager {
    
    BaseService<? extends BaseOperateItem, ? extends BaseExample> getIdentifiableService(String type);

    public BaseOperateItem getIdentifiableByTypeAndId(String type, Integer id);

    public BaseOperateItem getIdentifiableWithDetailByTypeAndId(String type, Integer id);

    public boolean identifiableRegistered(String type);

    public void deleteIdentifiableByTypeAndId(String type, int id);
}
