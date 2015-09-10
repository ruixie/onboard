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
     * 邀请用户加入公司
     * 
     * @param companyId
     *            公司id
     * @param email
     *            email地址
     */
    void sendInvitation(int companyId, String email);

    /**
     * 邀请用户加入项目，传入项目列表的目的是为了在邮件中显示
     * 
     * @param companyId
     *            公司id
     * @param email
     *            email地址
     * @param projectIds
     *            项目id列表
     */
    void sendInvitation(int companyId, String email, List<Project> projects);

    /**
     * 确认邀请是否有效
     * 
     * @param companyId
     *            公司id
     * @param token
     *            令牌
     * @return 如果有效返回对应的email地址，否则返回null
     */
    String authenticateInvitation(int companyId, String token);

    /**
     * 完成邀请，删除令牌
     * 
     * @param companyId
     *            公司id
     * @Param user 用户对象
     * @param token
     *            令牌
     */
    void completeInvitation(int companyId, User user, String token);

    /**
     * 获取公司下所有邀请
     * 
     * @param companyId
     * @return
     */
    List<Invitation> getAllInvitations(int companyId);

    /**
     * 获取Invitation
     * 
     * @param id
     * @return
     */
    Invitation getInvitationById(int id);

    /**
     * 删除Invitation
     * 
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
