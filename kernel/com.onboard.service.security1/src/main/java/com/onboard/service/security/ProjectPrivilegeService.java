package com.onboard.service.security;

import java.util.List;

import com.onboard.domain.model.ProjectPrivilege;
import com.onboard.domain.model.User;

/**
 * {@link ProjectPrivilege} Service Interface
 * 
 * @author XR, yewei
 * 
 */
public interface ProjectPrivilegeService {
    /**
     * Get item by id
     * 
     * @param id
     * @return item
     */
    ProjectPrivilege getProjectPrivilegeById(int id);

    /**
     * Get item list
     * 
     * @param start
     * @param limit
     * @return the item list
     */
    List<ProjectPrivilege> getProjectPrivileges(int start, int limit);

    /**
     * Get item list by example
     * 
     * @param item
     * @param start
     * @param limit
     * @return the item list
     */
    List<ProjectPrivilege> getProjectPrivilegesByExample(ProjectPrivilege item, int start, int limit);

    /**
     * Get item count by example
     * 
     * @param item
     * @return the count
     */
    int countByExample(ProjectPrivilege item);

    /**
     * Create
     * 
     * @param item
     * @return the created ProjectPrivilege
     */
    ProjectPrivilege createProjectPrivilege(ProjectPrivilege item);

    /**
     * Update
     * 
     * @param item
     * @return the updated item
     */
    ProjectPrivilege updateProjectPrivilege(ProjectPrivilege item);

    /**
     * Delete
     * 
     * @param id
     */
    void deleteProjectPrivilege(int id);

    /**
     * 获取用户在项目的权限，如果权限尚不存在，则创建一个
     * 
     * @param companyId
     * @param userId
     * @return
     */
    ProjectPrivilege getOrCreateProjectPrivilegeByUserId(int projectId, int userId);

    /**
     * 通过uesrId获取projectPrivilege
     * 
     * @param userId
     * @return
     */
    List<ProjectPrivilege> getProjectPrivilegesByUserId(int userId);

    /**
     * 通过projectId获取项目管理员
     * 
     * @param project
     * @return
     */
    List<User> getProjectAdminsByProject(int projectId);

    /**
     * 设置项目管理员
     * 
     * @param users
     * @param projectId
     * @return
     */
    void setProjectPrivilegeByUserListByProjectId(List<User> users, int projectId);

    /**
     * 添加项目管理员
     * 
     * @param userId
     * @param projectId
     */
    void addProjectAdmin(int userId, int projectId);

    /**
     * 删除项目管理员
     * 
     * @param userId
     * @param projectId
     */
    void removeProjectAdmin(int userId, int projectId);
}
