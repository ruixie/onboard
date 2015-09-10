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

import java.util.Date;

public class CompanyObject implements BaseItem {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.id
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.name
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.creatorId
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private Integer creatorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.created
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private Date created;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.updated
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private Date updated;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.deleted
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private Boolean deleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.privileged
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private Boolean privileged;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.money
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private Integer money;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.lastPayTime
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private Date lastPayTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.creatorAvatar
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private String creatorAvatar;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.id
     *
     * @return the value of company.id
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.id
     *
     * @param id the value for company.id
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.name
     *
     * @return the value of company.name
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.name
     *
     * @param name the value for company.name
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.creatorId
     *
     * @return the value of company.creatorId
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public Integer getCreatorId() {
        return creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.creatorId
     *
     * @param creatorId the value for company.creatorId
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.created
     *
     * @return the value of company.created
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.created
     *
     * @param created the value for company.created
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.updated
     *
     * @return the value of company.updated
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.updated
     *
     * @param updated the value for company.updated
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.deleted
     *
     * @return the value of company.deleted
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.deleted
     *
     * @param deleted the value for company.deleted
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.privileged
     *
     * @return the value of company.privileged
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public Boolean getPrivileged() {
        return privileged;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.privileged
     *
     * @param privileged the value for company.privileged
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setPrivileged(Boolean privileged) {
        this.privileged = privileged;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.money
     *
     * @return the value of company.money
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public Integer getMoney() {
        return money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.money
     *
     * @param money the value for company.money
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setMoney(Integer money) {
        this.money = money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.lastPayTime
     *
     * @return the value of company.lastPayTime
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public Date getLastPayTime() {
        return lastPayTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.lastPayTime
     *
     * @param lastPayTime the value for company.lastPayTime
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setLastPayTime(Date lastPayTime) {
        this.lastPayTime = lastPayTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.creatorAvatar
     *
     * @return the value of company.creatorAvatar
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public String getCreatorAvatar() {
        return creatorAvatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.creatorAvatar
     *
     * @param creatorAvatar the value for company.creatorAvatar
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setCreatorAvatar(String creatorAvatar) {
        this.creatorAvatar = creatorAvatar == null ? null : creatorAvatar.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public CompanyObject(CompanyObject parent) {
        this.id = parent.getId();
        this.name = parent.getName();
        this.creatorId = parent.getCreatorId();
        this.created = parent.getCreated();
        this.updated = parent.getUpdated();
        this.deleted = parent.getDeleted();
        this.privileged = parent.getPrivileged();
        this.money = parent.getMoney();
        this.lastPayTime = parent.getLastPayTime();
        this.creatorAvatar = parent.getCreatorAvatar();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public CompanyObject() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public CompanyObject(int id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public CompanyObject(boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public CompanyObject(int id, boolean deleted) {
        this.id = id;
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    @Override
    public CompanyObject copy() {
        return new CompanyObject(this);
    }
}