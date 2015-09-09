package com.onboard.service.security.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onboard.domain.mapper.ProjectPrivilegeMapper;
import com.onboard.domain.mapper.model.ProjectPrivilegeExample;
import com.onboard.domain.model.ProjectPrivilege;
import com.onboard.domain.model.User;
import com.onboard.service.account.UserService;
import com.onboard.service.security.ProjectPrivilegeService;

/**
 * {@link com.onboard.service.security.ProjectPrivilegeService} Service
 * implementation
 * 
 * @author XR
 * 
 */
@Transactional
@Service("projectPrivilegeServiceBean")
public class ProjectPrivilegeServiceImpl implements ProjectPrivilegeService {

    @Autowired
    private ProjectPrivilegeMapper projectPrivilegeMapper;

    @Autowired
    private UserService userService;

    @Override
    public ProjectPrivilege getProjectPrivilegeById(int id) {
        return projectPrivilegeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ProjectPrivilege> getProjectPrivileges(int start, int limit) {
        ProjectPrivilegeExample example = new ProjectPrivilegeExample(new ProjectPrivilege());
        example.setLimit(start, limit);
        return projectPrivilegeMapper.selectByExample(example);
    }

    @Override
    public List<ProjectPrivilege> getProjectPrivilegesByExample(ProjectPrivilege item, int start, int limit) {
        ProjectPrivilegeExample example = new ProjectPrivilegeExample(item);
        example.setLimit(start, limit);
        return projectPrivilegeMapper.selectByExample(example);
    }

    @Override
    public int countByExample(ProjectPrivilege item) {
        ProjectPrivilegeExample example = new ProjectPrivilegeExample(item);
        return projectPrivilegeMapper.countByExample(example);
    }

    @Override
    public ProjectPrivilege createProjectPrivilege(ProjectPrivilege item) {
        projectPrivilegeMapper.insert(item);
        return item;
    }

    @Override
    public ProjectPrivilege updateProjectPrivilege(ProjectPrivilege item) {
        projectPrivilegeMapper.updateByPrimaryKey(item);
        return item;
    }

    @Override
    public void deleteProjectPrivilege(int id) {
        projectPrivilegeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ProjectPrivilege getOrCreateProjectPrivilegeByUserId(int projectId, int userId) {
        ProjectPrivilege sample = new ProjectPrivilege();
        sample.setProjectId(projectId);
        sample.setUserId(userId);
        List<ProjectPrivilege> ps = projectPrivilegeMapper.selectByExample(new ProjectPrivilegeExample(sample));
        if (ps == null || ps.size() == 0) {
            ProjectPrivilege p = new ProjectPrivilege();
            p.setProjectId(projectId);
            p.setUserId(userId);
            p.setIsAdmin(false);
            return createProjectPrivilege(p);
        }

        return ps.get(0);
    }

    @Override
    public List<ProjectPrivilege> getProjectPrivilegesByUserId(int userId) {
        ProjectPrivilege sample = new ProjectPrivilege();
        sample.setUserId(userId);
        return projectPrivilegeMapper.selectByExample(new ProjectPrivilegeExample(sample));
    }

    @Override
    public List<User> getProjectAdminsByProject(int projectId) {

        ProjectPrivilege sample = new ProjectPrivilege();
        sample.setProjectId(projectId);
        sample.setIsAdmin(true);
        List<ProjectPrivilege> ps = projectPrivilegeMapper.selectByExample(new ProjectPrivilegeExample(sample));

        List<User> users = new ArrayList<User>();
        for (ProjectPrivilege p : ps) {
            users.add(userService.getById(p.getUserId()));
        }
        return users;
    }

    @Override
    public void addProjectAdmin(int userId, int projectId) {
        ProjectPrivilege pp = getOrCreateProjectPrivilegeByUserId(projectId, userId);
        pp.setIsAdmin(true);
        updateProjectPrivilege(pp);
    }

    @Override
    public void removeProjectAdmin(int userId, int projectId) {
        ProjectPrivilege pp = getOrCreateProjectPrivilegeByUserId(projectId, userId);
        pp.setIsAdmin(false);
        updateProjectPrivilege(pp);
    }

}
