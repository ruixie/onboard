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
package com.onboard.domain.model;

import java.util.List;

import com.onboard.domain.mapper.model.DocumentObject;
import com.onboard.domain.model.type.Commentable;
import com.onboard.domain.model.type.Indexable;
import com.onboard.domain.model.type.Recommendable;
import com.onboard.domain.model.type.Subscribable;

/**
 * Domain model: Document
 * 
 * @generated_by_elevenframework
 * 
 */
public class Document extends DocumentObject implements Subscribable, Indexable, Commentable, Recommendable {

    private static final long serialVersionUID = 1L;

    public enum DocType {
        TXT((byte) 1), MD((byte) 2), HTML((byte) 0);

        private Byte docType;

        private DocType(Byte docType) {
            this.docType = docType;
        }

        public Byte getValue() {
            return docType;
        }
    }

    private List<Comment> comments;

    private List<User> subscribers;

    private User creator;

    private List<Attachment> attachments;

    public Document() {
        super();
    }

    public Document(int id) {
        super(id);
    }

    public Document(boolean deleted) {
        super(deleted);
    }

    public Document(int id, boolean deleted) {
        super(id, deleted);
    }

    public Document(DocumentObject obj) {
        super(obj);
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
    public List<User> getSubscribers() {
        return subscribers;
    }

    @Override
    public void setSubscribers(List<User> subscribers) {
        this.subscribers = subscribers;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    @Override
    public String getType() {
        return "document";
    }

    @Override
    public String getCommentSubject() {
        return getTitle();
    }

    @Override
    public String getSubscribableType() {
        return "document";
    }

    @Override
    public Integer getSubscribableId() {
        return getId();
    }

    @Override
    public String getSubscribableSubject() {
        return getTitle();
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    @Override
    public boolean equals(Object obj) {
        if (!obj.getClass().equals(Document.class)) {
            return false;
        }
        Document document = (Document) obj;
        return getId().equals(document.getId());
    }

    @Override
    public String generateText() {
        return String.format("%s %s", getTitle(), getContent());
    }

    @Override
    public boolean trashRequried() {
        return true;
    }

}
