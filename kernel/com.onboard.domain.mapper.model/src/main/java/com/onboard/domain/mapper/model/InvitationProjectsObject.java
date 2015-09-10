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
package com.onboard.domain.mapper.model;

import com.onboard.domain.mapper.model.common.BaseItem;

public class InvitationProjectsObject implements BaseItem {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column invitation_projects.id
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column invitation_projects.invitationId
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private Integer invitationId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column invitation_projects.projectId
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private Integer projectId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column invitation_projects.id
     *
     * @return the value of invitation_projects.id
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column invitation_projects.id
     *
     * @param id the value for invitation_projects.id
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column invitation_projects.invitationId
     *
     * @return the value of invitation_projects.invitationId
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public Integer getInvitationId() {
        return invitationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column invitation_projects.invitationId
     *
     * @param invitationId the value for invitation_projects.invitationId
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setInvitationId(Integer invitationId) {
        this.invitationId = invitationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column invitation_projects.projectId
     *
     * @return the value of invitation_projects.projectId
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column invitation_projects.projectId
     *
     * @param projectId the value for invitation_projects.projectId
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table invitation_projects
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public InvitationProjectsObject(InvitationProjectsObject parent) {
        this.id = parent.getId();
        this.invitationId = parent.getInvitationId();
        this.projectId = parent.getProjectId();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table invitation_projects
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public InvitationProjectsObject() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table invitation_projects
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public InvitationProjectsObject(int id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table invitation_projects
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    @Override
    public InvitationProjectsObject copy() {
        return new InvitationProjectsObject(this);
    }
}