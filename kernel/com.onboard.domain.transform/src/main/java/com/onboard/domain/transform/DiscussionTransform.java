package com.onboard.domain.transform;

import org.springframework.beans.BeanUtils;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.onboard.domain.model.Discussion;
import com.onboard.dto.DiscussionDTO;

public class DiscussionTransform {

    public static final Function<Discussion, DiscussionDTO> DISCUSSION_DTO_FUNCTION = new Function<Discussion, DiscussionDTO>() {
        @Override
        public DiscussionDTO apply(Discussion discussion) {
            return discussionToDiscussionDTO(discussion);
        }
    };

    public static DiscussionDTO discussionToDiscussionDTO(Discussion discussion) {
        DiscussionDTO discussionDTO = new DiscussionDTO();
        BeanUtils.copyProperties(discussion, discussionDTO);
        return discussionDTO;
    }

    public static DiscussionDTO discussionToDiscussionDTOWithDetail(Discussion discussion) {
        DiscussionDTO discussionDTO = new DiscussionDTO();
        BeanUtils.copyProperties(discussion, discussionDTO);
        if (discussion.getComments() != null) {
            discussionDTO.setComments(Lists.transform(discussion.getComments(),
                    CommentTransform.COMMENT_TO_DTO_FUNCTION));
        }
        if (discussion.getSubscribers() != null) {
            discussionDTO.setSubscribers(Lists.transform(discussion.getSubscribers(),
                    UserTransform.USER_TO_USERDTO_FUNCTION));
        }
        if (discussion.getAttachments() != null) {
            discussionDTO.setAttachments(Lists.transform(discussion.getAttachments(),
                    AttachmentTransform.ATTACHMENT_TO_ATTACHMENTDTO_FUNCTION));
        }
        return discussionDTO;
    }

}
