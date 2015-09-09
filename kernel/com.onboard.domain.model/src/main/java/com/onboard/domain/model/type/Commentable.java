package com.onboard.domain.model.type;

import java.util.List;

import com.onboard.domain.model.Comment;

/**
 * 可评论的对象
 * 
 * @author yewei
 * 
 */
public interface Commentable extends Subscribable {

    List<Comment> getComments();

    void setComments(List<Comment> comments);

    String getCommentSubject();
}
