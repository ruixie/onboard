package com.onboard.domain.model.type;

import java.util.List;

import com.onboard.domain.model.Attachment;

/**
 * 可添加附件的对象
 * 
 * @author yewei
 * 
 */
public interface Attachable extends BaseProjectItem {

    List<Attachment> getAttachments();

    void setAttachments(List<Attachment> attachments);

    List<Attachment> getDiscardAttachments();

    void setDiscardAttachments(List<Attachment> attachments);
}
