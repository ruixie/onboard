package com.onboard.domain.model;

import java.util.List;

import com.onboard.domain.mapper.model.CompanyObject;
import com.onboard.domain.model.type.BaseOperateItem;

/**
 * 领域模型：Company
 * 
 * @author ruici
 * 
 */
public class Company extends CompanyObject implements BaseOperateItem {

    private static final long serialVersionUID = 2557250479308921133L;

    /**
     * 项目列表
     */
    private List<Project> projects;

    /**
     * 公司成员数量
     */
    private Integer userCount;

    /**
     * 创建人
     */
    private User creator;

    public Company() {
        super();
    }

    public Company(int id) {
        super(id);
    }

    public Company(CompanyObject parent) {
        super(parent);
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    @Override
    public String getType() {
        return "company";
    }

    @Override
    public boolean trashRequried() {
        return true;
    }

}
