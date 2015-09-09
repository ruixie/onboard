package com.onboard.service.collaboration.attach;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.onboard.domain.model.Comment;
import com.onboard.domain.model.type.BaseProjectItem;
import com.onboard.domain.model.type.IdentifiableOperator;
import com.onboard.service.collaboration.CommentService;
import com.onboard.service.common.attach.IdentifiableAttachService;

@Service("commentAttachServiceBean")
public class CommentAttachServiceImpl implements IdentifiableAttachService {

    @Autowired
    CommentService commentService;

    @Override
    public String attachType() {
        return IdentifiableOperator.NONE_TYPE;
    }

    @Override
    public List<? extends BaseProjectItem> getIdentifiablesByAttachId(int attachId) {
        return Lists.newArrayList();
    }

    @Override
    public String modelType() {
        return new Comment().getType();
    }

    @Override
    public List<? extends BaseProjectItem> getIdentifiablesByAttachId(String attachType, int attachId) {
        return commentService.getCommentsByTopic(attachType, attachId, 0, -1);
    }

}
