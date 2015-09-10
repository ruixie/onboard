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

public class DocumentObject implements BaseItem {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column document.id
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column document.projectId
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private Integer projectId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column document.title
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column document.content
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column document.creatorId
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private Integer creatorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column document.deleted
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private Boolean deleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column document.created
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private Date created;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column document.updated
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private Date updated;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column document.creatorName
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private String creatorName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column document.companyId
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private Integer companyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column document.isHomePage
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private Boolean isHomePage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column document.docType
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private Byte docType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column document.creatorAvatar
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    private String creatorAvatar;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column document.id
     *
     * @return the value of document.id
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column document.id
     *
     * @param id the value for document.id
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column document.projectId
     *
     * @return the value of document.projectId
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column document.projectId
     *
     * @param projectId the value for document.projectId
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column document.title
     *
     * @return the value of document.title
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column document.title
     *
     * @param title the value for document.title
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column document.content
     *
     * @return the value of document.content
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column document.content
     *
     * @param content the value for document.content
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column document.creatorId
     *
     * @return the value of document.creatorId
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public Integer getCreatorId() {
        return creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column document.creatorId
     *
     * @param creatorId the value for document.creatorId
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column document.deleted
     *
     * @return the value of document.deleted
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column document.deleted
     *
     * @param deleted the value for document.deleted
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column document.created
     *
     * @return the value of document.created
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column document.created
     *
     * @param created the value for document.created
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column document.updated
     *
     * @return the value of document.updated
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column document.updated
     *
     * @param updated the value for document.updated
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column document.creatorName
     *
     * @return the value of document.creatorName
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column document.creatorName
     *
     * @param creatorName the value for document.creatorName
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName == null ? null : creatorName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column document.companyId
     *
     * @return the value of document.companyId
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column document.companyId
     *
     * @param companyId the value for document.companyId
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column document.isHomePage
     *
     * @return the value of document.isHomePage
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public Boolean getIsHomePage() {
        return isHomePage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column document.isHomePage
     *
     * @param isHomePage the value for document.isHomePage
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setIsHomePage(Boolean isHomePage) {
        this.isHomePage = isHomePage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column document.docType
     *
     * @return the value of document.docType
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public Byte getDocType() {
        return docType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column document.docType
     *
     * @param docType the value for document.docType
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setDocType(Byte docType) {
        this.docType = docType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column document.creatorAvatar
     *
     * @return the value of document.creatorAvatar
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public String getCreatorAvatar() {
        return creatorAvatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column document.creatorAvatar
     *
     * @param creatorAvatar the value for document.creatorAvatar
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public void setCreatorAvatar(String creatorAvatar) {
        this.creatorAvatar = creatorAvatar == null ? null : creatorAvatar.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public DocumentObject(DocumentObject parent) {
        this.id = parent.getId();
        this.projectId = parent.getProjectId();
        this.title = parent.getTitle();
        this.content = parent.getContent();
        this.creatorId = parent.getCreatorId();
        this.deleted = parent.getDeleted();
        this.created = parent.getCreated();
        this.updated = parent.getUpdated();
        this.creatorName = parent.getCreatorName();
        this.companyId = parent.getCompanyId();
        this.isHomePage = parent.getIsHomePage();
        this.docType = parent.getDocType();
        this.creatorAvatar = parent.getCreatorAvatar();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public DocumentObject() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public DocumentObject(int id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public DocumentObject(boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    public DocumentObject(int id, boolean deleted) {
        this.id = id;
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table document
     *
     * @mbggenerated Wed Aug 26 19:51:19 CST 2015
     */
    @Override
    public DocumentObject copy() {
        return new DocumentObject(this);
    }
}