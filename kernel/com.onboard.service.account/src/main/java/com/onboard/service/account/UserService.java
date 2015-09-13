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
 * This service is about registration and authenticate of {@link User}
 * 
 * @author ruici, huangsz
 * 
 */
public interface UserService extends BaseService<User, UserExample> {

	/**
	 * Register an user using given user object and a name of company
	 * 
	 * @param user
	 *            An object of user contains basic information
	 * @param companyName
	 *            The name of company that the user want's to create when
	 *            registered
	 */
	User signUp(User user, String companyName);

	/**
	 * Send an confirmation email to an user, which contains a token related to
	 * this user, the user can use this token to confirm his/her email address
	 * then finish the registration
	 * 
	 * @param user
	 *            The user that the email sent to
	 */
	void sendConfirmationEmail(User user);

	/**
	 * Authenticate the given token to see if the given user register using the
	 * right email address(To see if the token user claims to get equals the
	 * token we sent)
	 * 
	 * @param token
	 *            The token user claims to get from the email
	 */
	boolean confirmRegisteredUser(int uid, String token);

	/**
	 * Check if an email address is already been used
	 * 
	 * @param email
	 *            The email address need to be checked
	 * @return the result of check
	 */
	boolean isEmailRegistered(String email);

	/**
	 * Authenticate the given identity and the given password to see if the user
	 * can login with these information, the identity here can be either email
	 * or username, which means we need to check both possibilities
	 * 
	 * @param emailOrUsername
	 *            The identity that the user claims, may be either email or
	 *            username
	 * @param password
	 *            The password that the user claims
	 * @return an object of the user if the information is valid, otherwise null
	 */
	User login(String emailOrUsername, String password);

	/**
	 * Try to help user reset their password, usually we sent an email with
	 * token to their email, then they can use the token(contains in an URL) to
	 * reset their password
	 * 
	 * @param email
	 *            The email address that the user claims
	 */
	void forgetPassword(String email);

	/**
	 * Try to reset some user's password to the given password, but we need to
	 * authenticate the given token first to ensure the account security and
	 * figure out which user wants to reset his/her password
	 * 
	 * @param password
	 *            The password that the user wants to change to
	 * @param token
	 *            The token that the user claims to get from the email(It's
	 *            possible to be a fake one)
	 * @return true if the token is valid, otherwise false
	 */
	boolean resetPassword(int uid, String password, String token);

	/**
	 * Get user by the given email address
	 * 
	 * @param email
	 *            The email that the user should have
	 * @return an object of user that meets the restriction, null if not exists.
	 */
	User getUserByEmail(String email);

	/**
	 * Get user by the given identity, the identity here can be either email or
	 * username
	 * 
	 * @param emailOrUsername
	 *            The identity that the user should have, can be either email or
	 *            username
	 * @return an object of user that meets the restriction, null if not exists.
	 */
	User getUserByEmailOrUsername(String emailOrUsername);

	/**
	 * Get all users in the given project
	 * 
	 * @param projectId
	 *            The id of the project
	 * @return a list of users that meets the restriction
	 */
	List<User> getUserByProjectId(int projectId);

	/**
	 * Get all users in the given company
	 * 
	 * @param companyId
	 *            The id of the company
	 * @return a list of users that meets the restriction
	 */
	List<User> getUserByCompanyId(int companyId);

	/**
	 * Get all users in the given department
	 * 
	 * @param groupId
	 *            The id of the department
	 * @param companyId
	 *            The id of the company
	 * @return a list of users that meets the restriction
	 */
	List<User> getUserByCompanyIdByDepartmentId(int groupId, int companyId);

	/**
	 * Get all users in the given company, then organized them by project
	 * 
	 * @param companyId
	 *            The id of the company
	 * @return a organized list of users that meets the restriction
	 */
	Map<Integer, List<User>> getAllProjectUsersInCompany(int companyId);

	/**
	 * Get all users that has department in the given company, then organized
	 * them by department
	 * 
	 * @param companyId
	 *            The id of the company
	 * @return a organized list of users that meets the restriction
	 */
	Map<Department, List<User>> getDepartmentedUserByCompanyId(Integer companyId);

	/**
	 * Get all users that doesn't have department in the given company
	 * 
	 * @param companyId
	 *            The id of the company
	 * @return a list of users that meets the restriction
	 */
	List<User> getUnDepartmentedUsersByCompanyId(Integer companyId);

	/**
	 * Update an user, without updating its password
	 * 
	 * @param user
	 *            An object of user contains its new information
	 * @param avatar
	 *            A file contains the new avatar, null if doesn't change
	 * @param filename
	 *            The filename that the avatar should save as, null if doesn't
	 *            change
	 */
	void updateUser(User user, byte[] avatar, String filename);

	/**
	 * Authenticate a token of type "RememberMe"
	 * 
	 * @param uid
	 *            The id of the user
	 * @param token
	 *            The token of the user
	 * @return an object the the user if the token is valid, otherwise null
	 */
	User authenticateRememberMeToken(int uid, String token);

	/**
	 * 删除“记住我”功能中记录的令牌
	 * 
	 * @param uid
	 *            用户主键
	 */
	void deleteRememberMeToken(int uid);

	/**
	 * 验证“忘记密码”功能中记录的令牌
	 * 
	 * @param uid
	 *            用户主键
	 * @param token
	 *            令牌信息
	 * @return 该令牌信息是否正确
	 */
	boolean authenticateForgetToken(int uid, String token);

	/**
	 * 判断特定用户是否属于特定团队
	 * 
	 * @param userId
	 *            用户主键
	 * @param companyId
	 *            团队主键
	 * @return 该判断是否正确
	 */
	boolean isUserInCompany(int userId, int companyId);

	/**
	 * 判断特定用户是否属于特定项目
	 * 
	 * @param userId
	 *            用户主键
	 * @param CompanyId
	 *            团队主键
	 * @param projectId
	 *            项目主键
	 * @return 该判断是否正确
	 */
	boolean isUserInProject(int userId, int companyId, int projectId);

	/**
	 * 根据邮件地址获取带有密码信息的用户对象
	 * 
	 * @param email
	 *            邮件地址
	 * @return 按要求从数据库中获取出的用户对象
	 */
	public User getUserWithPasswordByEmail(String email);

	/**
	 * 通过用户名或邮件地址获取带有密码信息的用户对象
	 * 
	 * @param emailOrUsername
	 *            用户名或邮件地址
	 * @return 按要求从数据库中获取出的用户对象
	 */
	public User getUserByEmailOrUsernameWithPassword(String emailOrUsername);

	/**
	 * 判断用户名是否已经被使用
	 * 
	 * @param username
	 *            用户名
	 * @return 该判断是否正确
	 */
	public Boolean containUsername(String username);

	/**
	 * 判断用户密码是否正确
	 * 
	 * @author Chenlong
	 * @param encPass
	 * @param rawPass
	 * @param salt
	 * @return 该判断是否正确
	 */
	public boolean isPasswordValid(String encPass, String rawPass, String salt);

	/**
	 * 对用户密码进行加密
	 * 
	 * @author Chenlong
	 * @param password
	 * @param salt
	 * @return
	 */
	public String createPassword(String password, String salt);

	/**
	 * 在一个用户列表中，筛选出属于特定项目的用户
	 * 
	 * @author Chenlong
	 * @param users
	 *            需要进行筛选的用户列表
	 * @param projectId
	 *            项目主键
	 * @return 筛选出的用户列表
	 */
	List<User> filterProjectMembers(List<User> users, int projectId);

}
