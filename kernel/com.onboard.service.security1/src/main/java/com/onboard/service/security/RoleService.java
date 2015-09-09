package com.onboard.service.security;

import java.util.List;

import com.onboard.domain.model.User;

/**
 * 角色服务
 * 
 * @author yewei
 * 
 */
public interface RoleService {

    /**
     * 团队拥有者，拥有最高权限，且默认是任何项目的成员
     * 
     * @param userId
     * @param companyId
     * @return
     */
    boolean companyOwner(int userId, int companyId);

    /**
     * 团队管理员，可以创建项目，并管理团队成员 团队管理员如果不在某个特定的项目,则不能对该项目进行管理 团队管理员加入某个项目,则默认为项目管理员
     * 
     * @param userId
     * @param companyId
     * @return
     */
    boolean companyAdmin(int userId, int companyId);

    /**
     * 在特定项目中的团队管理员
     * 
     * @param userId
     * @param companyId
     * @param projectId
     * @return
     */
    boolean companyAdminInSpecificProject(int userId, int companyId, int projectId);

    /**
     * 团队中可以进行项目创建的人员
     * 
     * @param userId
     * @param companyId
     * @return
     */
    boolean companyMemberCanCreateProject(int userId, int companyId);

    /**
     * 团队成员
     * 
     * @param userId
     * @param companyId
     * @return
     */
    boolean companyMember(int userId, int companyId);

    /**
     * 一个项目的管理员，可以进行项目信息编辑和人员管理
     * 
     * @param userId
     * @param companyId
     * @param projectId
     * @return
     */
    boolean projectAdmin(int userId, int companyId, int projectId);

    /**
     * 普通项目成员，可以参与项目
     * 
     * @param userId
     * @param projectId
     * @return
     */
    boolean projectMember(int userId, int companyId, int projectId);

    /**
     * 判断用户是否为对象的创建者
     * 
     * @param userId
     *            用户id
     * @param id
     *            对象id
     * @param type
     *            对象类型
     * @return 如果是对象创建者，返回true
     */
    boolean identityCreator(int userId, int id, String type);

    /**
     * 判断一个用户是否能对另外一个用户设置权限
     * 
     * @param currentUserId
     *            设置权限的用户id
     * @param userId
     *            被设置权限的用户id
     * @param companyId
     *            公司id
     * @return 如果符合条件，返回true
     */
    boolean setPrivilege(int currentUserId, int userId, int companyId);

    /**
     * 项目创建者，默认会赋予项目管理员权限
     * 
     * @param userId
     * @param projectId
     * @return
     */
    boolean projectCreator(int userId, int projectId);

    /**
     * CompanyOwner权限拥有者
     * 
     * @param companyId
     * @return
     */
    User getCompanyOwnerByCompanyId(int companyId);

    /**
     * CompanyAdmin权限拥有者列表
     * 
     * @param companyId
     * @return
     */
    List<User> getCompanyAdminsByCompanyId(int companyId);

    /**
     * 特定project的CompanyAdmin权限拥有者列表
     * 
     * @param companyId
     * @return
     */
    List<User> getCompanyAdminsByCompanyIdInSpecificProject(int companyId, int projectId);

    /**
     * ProjectAdmin权限拥有者列表
     * 
     * @param projectId
     * @return
     */
    List<User> getProjectAdminsByProjectId(int projectId);

    /**
     * ProjectMember权限拥有者列表
     * 
     * @param projectId
     * @return
     */
    List<User> getProjectMembersByProjectId(int projectId);

    /**
     * CompanyMember权限拥有者列表
     * 
     * @param companyId
     * @return
     */
    List<User> getCompanyMembersByCompanyId(int companyId);

}
