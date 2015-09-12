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

import com.onboard.domain.model.Invitation;
import com.onboard.domain.model.Project;
import com.onboard.domain.model.User;

public interface AccountService {

    /**
     * 邀请用户加入团队
     * @param companyId 团队主键
     * @param email 该用户的邮件地址
     */
    void sendInvitation(int companyId, String email);

    /**
     * 邀请用户加入项目
     * @param companyId 团队主键
     * @param email 该用户的邮件地址
     * @param projects 项目主键列表，该列表中的项目会在邮件当中进行显示
     */
    void sendInvitation(int companyId, String email, List<Project> projects);

    /**
     * 判断一个令牌是否有效
     * @param companyId 团队主键
     * @param token 需要检验的令牌
     * @return 当令牌有效时，返回该令牌所属用户的邮件地址，否则返回null。
     */
    String authenticateInvitation(int companyId, String token);

    /**
     * 在邀请完成后，删除对应的令牌
     * @param companyId 团队主键
     * @param token 需要被删除的令牌
     * @param user 用户对象
     */
    void completeInvitation(int companyId, User user, String token);

    /**
     * 获取一个团队中所有邀请的列表
     * @param companyId 团队主键
     * @return 按要求从数据库中获取出的邀请列表
     */
    List<Invitation> getAllInvitations(int companyId);

    /**
     * 根据主键获取邀请对象
     * @param id
     * @return 按要求从数据库中获取出的邀请对象
     */
    Invitation getInvitationById(int id);

    /**
     * 根据主键删除邀请对象
     * @param id
     */
    void deleteInvitationById(int id);

    /**
     * TODO: to delete
     * @param user
     * @param projectId
     */
    void addActivityInfo(User user, int projectId);

}
