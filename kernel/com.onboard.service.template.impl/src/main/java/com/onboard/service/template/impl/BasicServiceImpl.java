package com.onboard.service.template.impl;

import java.util.List;

import com.onboard.domain.mapper.model.common.BaseExample;
import com.onboard.service.template.BasicService;

public class BasicServiceImpl implements BasicService {

    @Override
    public CommonMapper getMapper() {
        return null;
    }

    @Override
    public Object getById(int id) {
        return getMapper().selectByPrimaryKey(id);
    }

    @Override
    public Object create(Object o) {
        this.initiateBeforeCreate(o);
        getMapper().insert(o);
        this.initiateAfterCreate(o);
        return o;
    }

    @Override
    public void update(Object o) {
        this.initiateBeforeUpdate(o);
        getMapper().updateByPrimaryKeySelective(o);
        this.initiateAfterUpdate(o);
    }

    @Override
    public void deleteById(int id) {
        this.initiateBeforeUpdate(id);
        getMapper().deleteByPrimaryKey(id);
        this.initiateAfterDelete(id);

    }

    @Override
    public List<Object> getByProject(int projectId, int start, int limit) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Object> getByCompany(int projectId, int start, int limit) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int countByExample(Object o) {

        return this.getMapper().countByExample(this.getExample(o));
    }

    @Override
    public Object getByExample() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object initiateBeforeCreate(Object o) {
        return null;
    }

    @Override
    public Object initiateBeforeUpdate(Object o) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Object o) {
        // TODO Auto-generated method stub

    }

    @Override
    public void initiateAfterUpdate(Object o) {

    }

    @Override
    public void initiateAfterCreate(Object o) {

    }

    @Override
    public BaseExample getExample(Object o) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object initiateBeforeDelete(Object o) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void initiateAfterDelete(Object o) {
        // TODO Auto-generated method stub

    }

}
