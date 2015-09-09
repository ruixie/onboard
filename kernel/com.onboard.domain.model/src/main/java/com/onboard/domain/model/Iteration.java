package com.onboard.domain.model;

import java.text.SimpleDateFormat;
import java.util.List;

import com.onboard.domain.mapper.model.IterationObject;
import com.onboard.domain.model.type.BaseProjectItem;
import com.onboard.domain.model.type.Commentable;
import com.onboard.domain.model.type.Iterable;
import com.onboard.domain.model.type.Recommendable;

/**
 * Domain model: Iteration
 * 
 * @generated_by_elevenframework
 * 
 */
public class Iteration extends IterationObject implements BaseProjectItem, Commentable, Recommendable {

    private static final long serialVersionUID = -8021956407484159866L;

    public enum IterationStatus {
        CREATED("created"), ACTIVE("active"), COMPLETED("completed");

        private String status;

        private IterationStatus(String status) {
            this.status = status;
        }

        public String getValue() {
            return this.status;
        }
    }

    private List<Iterable> iterables;

    private List<User> subscribers;

    private List<Comment> comments;

    public Iteration() {
        super();
    }

    public Iteration(int id) {
        super(id);
    }

    public Iteration(IterationObject obj) {
        super(obj);
    }

    @Override
    public String getType() {
        return "iteration";
    }

    public List<Iterable> getIterables() {
        return iterables;
    }

    public void setIterables(List<Iterable> iterables) {
        this.iterables = iterables;
    }

    @Override
    public String generateText() {
        return "";
    }

    @Override
    public String getSubscribableType() {
        return getType();
    }

    @Override
    public Integer getSubscribableId() {
        return getId();
    }

    @Override
    public String getSubscribableSubject() {
        return getName();
    }

    @Override
    public List<User> getSubscribers() {
        return subscribers;
    }

    @Override
    public void setSubscribers(List<User> users) {
        this.subscribers = users;
    }

    @Override
    public List<Comment> getComments() {
        return this.comments;
    }

    @Override
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String getCommentSubject() {
        return this.getSubscribableSubject();
    }

    public String getName() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return String.format("迭代%s--%s", sdf.format(getStartTime()), sdf.format(getEndTime()));
    }

    @Override
    public boolean trashRequried() {
        return false;
    }

}
