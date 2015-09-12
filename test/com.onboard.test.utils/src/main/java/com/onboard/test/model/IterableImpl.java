package com.onboard.test.model;

import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;
import com.onboard.domain.model.type.Boardable;
import com.onboard.domain.model.type.Iterable;
import com.onboard.test.moduleutils.ModuleHelper;

public class IterableImpl extends BaseProjectItemImpl implements Iterable{
    
    private static final long serialVersionUID = 5841525531476026727L;
    private Boolean completed = false;
    private Date completedTime = ModuleHelper.completed;
    private Boolean iterationCompleted = false;
    private Date iterationCompletedTime = ModuleHelper.completed;
    private List<Boardable> boardables = Lists.newArrayList();
    
    public IterableImpl() {
        super();
    }
    public IterableImpl(Integer id, String type) {
        super(id, type);
    }
    @Override
    public Boolean getCompleted() {
        return completed;
    }
    @Override
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
    @Override
    public Date getCompletedTime() {
        return completedTime;
    }
    @Override
    public void setCompletedTime(Date completedTime) {
        this.completedTime = completedTime;
    }
    @Override
    public Boolean getIterationCompleted() {
        return iterationCompleted;
    }
    @Override
    public void setIterationCompleted(Boolean iterationCompleted) {
        this.iterationCompleted = iterationCompleted;
    }
    @Override
    public Date getIterationCompletedTime() {
        return iterationCompletedTime;
    }
    @Override
    public void setIterationCompletedTime(Date iterationCompletedTime) {
        this.iterationCompletedTime = iterationCompletedTime;
    }
    @Override
    public List<Boardable> getBoardables() {
        return boardables;
    }
    public void setBoardables(List<Boardable> boardables) {
        this.boardables = boardables;
    }

}