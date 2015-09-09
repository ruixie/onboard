package com.onboard.service.template;

import java.util.List;

import com.onboard.domain.mapper.model.common.BaseExample;

public interface BasicService<T> {

    public Object getMapper();

    public Object getById(int id);

    public abstract Object initiateBeforeCreate(Object o);

    public abstract Object initiateBeforeUpdate(Object o);

    public abstract Object initiateBeforeDelete(Object o);

    public abstract void initiateAfterUpdate(Object o);

    public abstract void initiateAfterCreate(Object o);

    public abstract void initiateAfterDelete(Object o);

    public T create(T t);

    public void update(T t);

    public void delete(T t);

    public List<T> getByProject(int projectId, int start, int limit);

    public List<T> getByCompany(int projectId, int start, int limit);

    public abstract int countByExample(T t);

    public BaseExample getExample(Object o);

    public T getByExample();

    public void deleteById(int id);

}
