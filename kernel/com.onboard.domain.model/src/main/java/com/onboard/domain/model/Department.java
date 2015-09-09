package com.onboard.domain.model;

import java.util.Date;

import com.onboard.domain.mapper.model.DepartmentObject;
import com.onboard.domain.model.type.BaseOperateItem;

/**
 * Domain model: Group
 * 
 * @generated_by_elevenframework
 * 
 */
public class Department extends DepartmentObject implements BaseOperateItem {

    private static final long serialVersionUID = -4840010149566893768L;

    public Department() {
        super();
    }

    public Department(int id) {
        super(id);
    }

    public Department(DepartmentObject obj) {
        super(obj);
    }

    @Override
    public String getType() {
        return "department";
    }

    @Override
    public Date getCreated() {
        return null;
    }

    @Override
    public void setCreated(Date created) {
    }

    @Override
    public Date getUpdated() {
        return null;
    }

    @Override
    public void setUpdated(Date updated) {
    }

    @Override
    public Boolean getDeleted() {
        return false;
    }

    @Override
    public void setDeleted(Boolean deleted) {
    }

    @Override
    public boolean trashRequried() {
        return false;
    }

}

