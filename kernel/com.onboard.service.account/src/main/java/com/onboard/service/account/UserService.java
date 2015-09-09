package com.onboard.service.account;

import java.util.List;
import java.util.Map;

import com.onboard.domain.mapper.model.UserExample;
import com.onboard.domain.model.Department;
import com.onboard.domain.model.User;
import com.onboard.service.base.BaseService;

/**
 * {@link User} 相关服务：用户注册、验证等账户相关功能
 * 
 * @author ruici, huangsz
 * 
 */
public interface UserService extends BaseService<User, UserExample> {

    /**
     * 注册用户
     * 
     * @param user
     * @param companyName
     *            公司名称
     * @throws Exception
     */
    User signUp(User user, String companyName);

    /**
     * 为指定用户生成一个Token，用于邮件确认账户，并发送确认信
     * 
     * @param user
     */
    void sendConfirmationEmail(User user);

    /**
     * 验证邮箱是否被注册过
     * 
     * @param email
     * @return
     */
    boolean isEmailRegistered(String email);

    /**
     * 验证用户，主要用户登录
     * 
     * @param user
     * @param password
     * @return
     */
    User login(String emailOrUsername, String password);

    /**
     * 忘记密码
     * 
     * @param email
     */
    void forgetPassword(String email);

    /**
     * 重置密码
     * 
     * @param password
     * @param token
     */
    boolean resetPassword(int uid, String password, String token);

    /**
     * 确认用户注册信息
     * 
     * @param token
     */
    boolean confirmRegisteredUser(int uid, String token);

    /**
     * 通过projectId获取用户
     * 
     * @param id
     * @return
     */
    List<User> getUserByProjectId(int projectId);


    /**
     * 获取一个分组内所有的用户
     * 
     * @param groupId
     * @param companyId
     * @return
     */
    List<User> getUserByCompanyIdByDepartmentId(int groupId, int companyId);

    /**
     * 获取公司下所有项目的项目用户列表
     * 
     * @param companyId
     * @return
     */
    Map<Integer, List<User>> getAllProjectUsersInCompany(int companyId);

    /**
     * 通过company选取用户
     * 
     * @param companyId
     * @return
     */
    List<User> getUserByCompanyId(int companyId);

    /**
     * 通过邮箱获取用户
     * 
     * @param email
     * @return
     */
    User getUserByEmail(String email);

    /**
     * 通过邮箱或用户名获取用户
     * 
     * @param usernameOrPassword
     * @return
     */
    User getUserByEmailOrUsername(String emailOrUsername);

    /**
     * 获得一个company内已经被分组的用户
     * 
     * @param email
     * @return
     */
    Map<Department, List<User>> getDepartmentedUserByCompanyId(Integer companyId);

    /**
     * 获取一个company内没有被分组的用户
     * 
     * @param companyId
     * @return
     */
    List<User> getUnDepartmentedUsersByCompanyId(Integer companyId);

    /**
     * 更新用户基本信息(不更新密码)
     * 
     * @param user
     */
    void updateUser(User user, byte[] avatar, String filename);

    /**
     * 验证remeberMe功能的token，如果成功则返回用户对象
     * 
     * @param token
     * @return user
     * @throws Exception
     */
    User authenticateRememberMeToken(int uid, String token);

    /**
     * 删除RememberMe Token，用于用户登出
     * 
     * @param uid
     */
    void deleteRememberMeToken(int uid);

    /**
     * 验证忘记密码功能的token
     * 
     * @param token
     * @return
     * @throws Exception
     */
    boolean authenticateForgetToken(int uid, String token);

    /**
     * 判断用户是否在公司中
     * 
     * @param userId
     * @param companyId
     * @return
     */
    boolean isUserInCompany(int userId, int companyId);

    /**
     * 判断用户是否在项目中
     * 
     * @param userId
     * @param CompanyId
     * @param projectId
     * @return
     */
    boolean isUserInProject(int userId, int companyId, int projectId);

    public User getUserWithPasswordByEmail(String email);

    /**
     * 通过用户名或邮箱获取带有密码信息的用户对象
     * 
     * @param emailOrUsername
     * @return
     */
    public User getUserByEmailOrUsernameWithPassword(String emailOrUsername);

    /**
     * 判断用户名是否存在
     * 
     * @param username
     * @return
     */
    public Boolean containUsername(String username);

    /**
     * 判断用户密码正确与否
     * 
     * @author Chenlong
     * @param encPass
     * @param rawPass
     * @param salt
     * @return
     */
    public boolean isPasswordValid(String encPass, String rawPass, String salt);

    /**
     * 加密
     * 
     * @author Chenlong
     * @param password
     * @param salt
     * @return
     */
    public String createPassword(String password, String salt);

    /**
     * 筛选出一个用户列表在项目中的成员
     * 
     * @author Chenlong
     * @param users
     * @param projectId
     * @return
     */
    List<User> filterProjectMembers(List<User> users, int projectId);

}
