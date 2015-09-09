package com.onboard.service.common.identifiable.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.onboard.domain.mapper.model.common.BaseExample;
import com.onboard.domain.model.type.BaseOperateItem;
import com.onboard.domain.model.type.BaseProjectItem;
import com.onboard.service.base.BaseService;
import com.onboard.service.common.identifiable.IdentifiableManager;

/**
 * 实现为{@link BaseProjectItem}的对象对应的访问服务，需要注册到该类中
 * 
 * @author yewei
 * 
 */
@Service("identifiableManagerBean")
public class IdentifiableManagerImpl implements IdentifiableManager {

    private final Map<String, BaseService<? extends BaseOperateItem, ? extends BaseExample>> identifialbeMap = Collections
            .synchronizedMap(new HashMap<String, BaseService<? extends BaseOperateItem, ? extends BaseExample>>());

    public synchronized void addIdentifiableService(
            BaseService<? extends BaseOperateItem, ? extends BaseExample> baseService) {
        if (baseService != null) {
            identifialbeMap.put(baseService.getModelType(), baseService);
        }
    }

    public synchronized void removeIdentifiableService(
            BaseService<? extends BaseOperateItem, ? extends BaseExample> baseService) {
        if (baseService != null) {
            identifialbeMap.remove(baseService.getModelType());
        }
    }

    @Override
    public BaseOperateItem getIdentifiableByTypeAndId(String type, Integer id) {
        BaseService<? extends BaseOperateItem, ? extends BaseExample> identifiableService = identifialbeMap.get(type);
        if (identifiableService == null) {
            return null;
        }
        return identifiableService.getById(id);
    }

    @Override
    public boolean identifiableRegistered(String type) {
        return identifialbeMap.get(type) != null;
    }

    @Override
    public BaseOperateItem getIdentifiableWithDetailByTypeAndId(String type, Integer id) {
        BaseService<? extends BaseOperateItem, ? extends BaseExample> identifiableService = identifialbeMap.get(type);
        if (identifiableService == null) {
            return null;
        }
        return identifiableService.getByIdWithDetail(id);
    }

    @Override
    public void deleteIdentifiableByTypeAndId(String type, int id) {
        BaseService<? extends BaseOperateItem, ? extends BaseExample> identifiableService = identifialbeMap.get(type);
        if (identifiableService == null) {
            return;
        }
        identifiableService.delete(id);
    }

    @Override
    public BaseService<? extends BaseOperateItem, ? extends BaseExample> getIdentifiableService(String type) {
        return identifialbeMap.get(type);
    }
}
