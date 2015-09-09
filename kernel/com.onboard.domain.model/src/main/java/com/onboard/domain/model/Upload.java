package com.onboard.domain.model;

import java.util.List;

import com.onboard.domain.mapper.model.UploadObject;
import com.onboard.domain.model.type.Attachable;
import com.onboard.domain.model.type.Commentable;
import com.onboard.domain.model.type.Indexable;
import com.onboard.domain.model.type.Recommendable;
import com.onboard.domain.model.type.Subscribable;

/**
 * Domain model: Upload
 * 
 * @generated_by_elevenframework
 * 
 */
public class Upload extends UploadObject implements Commentable, Subscribable, Attachable, Indexable, Recommendable {

    private static final long serialVersionUID = 1L;

    private List<Comment> comments;

    private List<Attachment> attachments;

    private List<Attachment> discardAttachments;

    private List<User> subscribers;

    public Upload() {
        super();
    }

    public Upload(int id) {
        super(id);
    }

    public Upload(boolean deleted) {
        super(deleted);
    }

    public Upload(int id, boolean deleted) {
        super(id, deleted);
    }

    public Upload(UploadObject obj) {
        super(obj);
    }

    @Override
    public List<Attachment> getDiscardAttachments() {
        return discardAttachments;
    }

    @Override
    public void setDiscardAttachments(List<Attachment> discardAttachments) {
        this.discardAttachments = discardAttachments;
    }

    @Override
    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public List<Attachment> getAttachments() {
        return attachments;
    }

    @Override
    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    @Override
    public List<User> getSubscribers() {
        return subscribers;
    }

    @Override
    public void setSubscribers(List<User> subscribers) {
        this.subscribers = subscribers;
    }

    @Override
    public String getType() {
        return "upload";
    }

    @Override
    public String getSubscribableType() {
        return "upload";
    }

    @Override
    public Integer getSubscribableId() {

        return getId();
    }

    @Override
    public String getSubscribableSubject() {

        return getContent();
    }

    @Override
    public String getCommentSubject() {
        return getContent();
    }

    @Override
    public String generateText() {
        return getContent() != null ? getContent() : "";
    }

    @Override
    public boolean trashRequried() {
        return true;
    }

}
