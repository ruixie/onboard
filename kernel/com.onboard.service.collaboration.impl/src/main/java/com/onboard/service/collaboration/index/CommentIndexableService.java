package com.onboard.service.collaboration.index;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.onboard.domain.mapper.CommentMapper;
import com.onboard.domain.mapper.model.CommentExample;
import com.onboard.domain.mapper.model.common.BaseExample;
import com.onboard.domain.model.Comment;
import com.onboard.domain.model.type.Commentable;
import com.onboard.domain.model.type.Indexable;
import com.onboard.service.collaboration.CommentService;
import com.onboard.service.index.custom.IndexableService;
import com.onboard.service.index.model.IndexDocument;
import com.onboard.service.index.model.IndexDocumentBuilder;

/**
 * 针对{@link Comment}实现的{@link IndexableService}
 * 
 * @author yewei
 *
 */
@Service("commentIndexableServiceBean")
public class CommentIndexableService implements IndexableService {

    @Autowired
    private CommentMapper commentMapper;
    
    @Autowired
    private CommentService commentService;

    @Override
    public String modelType() {
        return new Comment().getType();
    }

    @Override
    public List<Indexable> getIndexablesByExample(BaseExample baseExample) {
        List<Indexable> items = new ArrayList<Indexable>();
        List<Comment> comments = commentMapper.selectByExample((CommentExample) baseExample);
        items.addAll(comments);
        return items;
    }

    @Override
    public IndexDocument indexableToIndexDocument(Indexable indexable) {
        Comment comment = commentMapper.selectByPrimaryKey(indexable.getId());
        Commentable commentable = commentService.getCommentTarget(
                comment.getAttachType(), comment.getAttachId());
        List<Integer> relators = Lists.newArrayList(comment.getCreatorId());
        return IndexDocumentBuilder
                .getBuilder()
                .indexable(comment)
                .content(comment.getContent())
                .attachTtitle(commentable.getCommentSubject())
                .relatorIds(relators)
                .build();
    }

}
