package com.onboard.dto;

import java.util.Date;
import java.util.List;

public class DiscussionDTO implements DTO {

    private Integer id;
    private Integer projectId;
    private String subject;
    private Integer creatorId;
    private Boolean deleted;
    private Date created;
    private Date updated;
    private Integer bcId;
    private String creatorName;
    private Integer companyId;
    private String content;
    private List<CommentDTO> comments;
    private List<UserDTO> subscribers;
    private List<AttachmentDTO> attachments;
    private List<AttachmentDTO> discardAttachments;

    public List<AttachmentDTO> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<AttachmentDTO> attachments) {
        this.attachments = attachments;
    }

    public List<AttachmentDTO> getDiscardAttachments() {
        return discardAttachments;
    }

    public void setDiscardAttachments(List<AttachmentDTO> discardAttachments) {
        this.discardAttachments = discardAttachments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Integer getBcId() {
        return bcId;
    }

    public void setBcId(Integer bcId) {
        this.bcId = bcId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }

    public List<UserDTO> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<UserDTO> subscribers) {
        this.subscribers = subscribers;
    }
}
