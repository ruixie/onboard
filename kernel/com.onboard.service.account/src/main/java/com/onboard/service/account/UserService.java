/*******************************************************************************
 * Copyright [2015] [Onboard team of SERC, Peking University]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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
     * @param user 需要被添加进数据库的用户对象
     * @param companyName 该用户默认属于的团队的名称
     */
    User signUp(User user, String companyName);

    /**
     * 为指定用户生成一个令牌，用于邮件确认账户，并发送确认信
     * @param user 需要生成令牌的用户
     */
    void sendConfirmationEmail(User user);

    /**
     * 验证某个邮件地址是否被注册过
     * @param email 需要被检查的邮件地址
     * @return 该邮件地址是否被注册过
     */
    boolean isEmailRegistered(String email);

    /**
     * 验证某个用户是否可以登录
     * @param emailOrUsername 用户在表单中填写的“邮件或用户名”
     * @param password 用户在表单中填写的“密码”
     * @return 当用户验证通过时返回该用户对象，否则返回null
     */
    User login(String emailOrUsername, String password);

    /**
     * 为用户发送解决“忘记密码”问题的邮件
     * @param email 用户在表单中填写的“邮件”
     */
    void forgetPassword(String email);

    /**
     * 根据令牌信息进行用户密码的重设
     * @param password 用户想要新设置的密码
     * @param token 用户在邮件中收到的令牌信息
     * @return 是否成功的进行了密码重设
     */
    boolean resetPassword(int uid, String password, String token);

    /**
     * 根据令牌信息进行用户注册的确认，以确保邮件地址的正确
     * @param token 用户在邮件中收到的令牌信息
     */
    boolean confirmRegisteredUser(int uid, String token);

    /**
     * 获取一个项目中的所有用户
     * @param projectId 项目主键
     * @return 按要求从数据库中获取出的用户列表
     */
    List<User> getUserByProjectId(int projectId);

    /**
     * 获取一个分组内所有的用户
     * @param groupId 分组主键
     * @param companyId 团队主键
     * @return 按要求从数据库中获取出的用户列表
     */
    List<User> getUserByCompanyIdByDepartmentId(int groupId, int companyId);

    /**
     * 获取一个团队中的所有用户，并按照项目进行分组
     * @param companyId
     * @return 按要求从数据库中获取出的用户列表
     */
    Map<Integer, List<User>> getAllProjectUsersInCompany(int companyId);

    /**
     * 获取一个团队中的所有用户
     * @param companyId 团队主键
     * @return 按要求从数据库中获取出的用户列表
     */
    List<User> getUserByCompanyId(int companyId);

    /**
     * 根据邮件地址获取对应的用户
     * @param email 目标用户的邮件地址
     * @return 按要求从数据库中获取出的用户对象
     */
    User getUserByEmail(String email);

    /**
     * 根据邮件地址或用户名获取对应的用户
     * @param usernameOrPassword 目标用户的邮件地址或用户名
     * @return 按要求从数据库中获取出的用户对象
     */
    User getUserByEmailOrUsername(String emailOrUsername);

    /**
     * 获取一个团队中的所有已分组用户，并按照其分组进行分组
     * @param companyId 团队主键
     * @return 按要求从数据库中获取出的用户列表
     */
    Map<Department, List<User>> getDepartmentedUserByCompanyId(Integer companyId);

    /**
     * 获取一个团队中的所有未分组用户
     * @param companyId 团队主键
     * @return 按要求从数据库中获取出的用户列表
     */
    List<User> getUnDepartmentedUsersByCompanyId(Integer companyId);

    /**
     * 更新用户的基本信息(不更新密码)
     * @param user 用户的新信息
     * @param avatar 头像的二进制信息
     * @param filename 头像存储的文件名
     */
    void updateUser(User user, byte[] avatar, String filename);

    /**
     * 验证“记住我”功能中记录的令牌并尝试登陆
     * @param uid 用户主键
     * @param token 令牌信息
     * @return 如果成功则返回用户对象，否则返回null
     */
    User authenticateRememberMeToken(int uid, String token);

    /**
     * 删除“记住我”功能中记录的令牌
     * @param uid 用户主键
     */
    void deleteRememberMeToken(int uid);

    /**
     * 验证“忘记密码”功能中记录的令牌
     * @param uid 用户主键
     * @param token 令牌信息
     * @return 该令牌信息是否正确
     */
    boolean authenticateForgetToken(int uid, String token);

    /**
     * 判断特定用户是否属于特定团队
     * @param userId 用户主键
     * @param companyId 团队主键
     * @return 该判断是否正确
     */
    boolean isUserInCompany(int userId, int companyId);

    /**
     * 判断特定用户是否属于特定项目
     * @param userId 用户主键
     * @param CompanyId 团队主键
     * @param projectId 项目主键
     * @return 该判断是否正确
     */
    boolean isUserInProject(int userId, int companyId, int projectId);

    /**
     * 根据邮件地址获取带有密码信息的用户对象
     * @param email 邮件地址
     * @return 按要求从数据库中获取出的用户对象
     */
    public User getUserWithPasswordByEmail(String email);

    /**
     * 通过用户名或邮件地址获取带有密码信息的用户对象
     * @param emailOrUsername 用户名或邮件地址
     * @return 按要求从数据库中获取出的用户对象
     */
    public User getUserByEmailOrUsernameWithPassword(String emailOrUsername);

    /**
     * 判断用户名是否已经被使用
     * @param username 用户名
     * @return 该判断是否正确
     */
    public Boolean containUsername(String username);

    /**
     * 判断用户密码是否正确
     * @author Chenlong
     * @param encPass
     * @param rawPass
     * @param salt
     * @return 该判断是否正确
     */
    public boolean isPasswordValid(String encPass, String rawPass, String salt);

    /**
     * 对用户密码进行加密
     * @author Chenlong
     * @param password
     * @param salt
     * @return
     */
    public String createPassword(String password, String salt);

    /**
     * 在一个用户列表中，筛选出属于特定项目的用户
     * @author Chenlong
     * @param users 需要进行筛选的用户列表
     * @param projectId 项目主键
     * @return 筛选出的用户列表
     */
    List<User> filterProjectMembers(List<User> users, int projectId);

}
