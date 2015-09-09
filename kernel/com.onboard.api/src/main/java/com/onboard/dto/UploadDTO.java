package com.onboard.dto;

import java.util.Date;
import java.util.List;

public class UploadDTO {
    private Integer id;

    private Integer projectId;

    private String content;

    private Integer creatorId;

    private Boolean deleted;

    private Date created;

    private Date updated;

    private String creatorName;

    private Integer companyId;

    private List<CommentDTO> commentDtos;

    private List<AttachmentDTO> attachmentDtos;

    private List<AttachmentDTO> discardAttachmentDtos;

    private List<UserDTO> subscriberDtos;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public List<CommentDTO> getCommentDtos() {
        return commentDtos;
    }

    public void setCommentDtos(List<CommentDTO> commentDtos) {
        this.commentDtos = commentDtos;
    }

    public List<AttachmentDTO> getAttachmentDtos() {
        return attachmentDtos;
    }

    public void setAttachmentDtos(List<AttachmentDTO> attachmentDtos) {
        this.attachmentDtos = attachmentDtos;
    }

    public List<AttachmentDTO> getDiscardAttachmentDtos() {
        return discardAttachmentDtos;
    }

    public void setDiscardAttachmentDtos(List<AttachmentDTO> discardAttachmentDtos) {
        this.discardAttachmentDtos = discardAttachmentDtos;
    }

    public List<UserDTO> getSubscriberDtos() {
        return subscriberDtos;
    }

    public void setSubscriberDTOs(List<UserDTO> subscriberDtos) {
        this.subscriberDtos = subscriberDtos;
    }

}
