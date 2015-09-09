package com.onboard.service.template.impl;

import com.onboard.domain.mapper.model.common.BaseExample;

public abstract class CommonMapper {

    public abstract Object selectByPrimaryKey(int id);

    public abstract Object insert(Object o);

    public abstract Object updateByPrimaryKeySelective(Object o);

    public abstract Object deleteByPrimaryKey(int id);

    public abstract int countByExample(BaseExample example);

}
