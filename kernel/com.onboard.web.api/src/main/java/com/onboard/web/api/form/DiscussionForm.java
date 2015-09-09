package com.onboard.web.api.form;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.onboard.domain.model.Discussion;

public class DiscussionForm extends Discussion {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Length(min = 1, max = 50, message = "标题长度必须在1-50之间")
    @NotNull
    @NotBlank
    private String subject;

    @Override
    public String getSubject() {
        return subject;
    }

    @Override
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public DiscussionForm() {
        super();
    }

    public DiscussionForm(Discussion discussion) {
        super(discussion);
        setSubject(discussion.getSubject());
        setComments(discussion.getComments());
        setAttachments(discussion.getAttachments());
        setSubscribers(discussion.getSubscribers());
        setCreated(new Date());
    }
}
