package com.onboard.service.collaboration.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onboard.domain.mapper.TodoDurationMapper;
import com.onboard.domain.mapper.model.TodoDurationExample;
import com.onboard.domain.model.TodoDuration;
import com.onboard.service.collaboration.TodoDurationService;

/**
 * {@link com.onboard.service.collaboration.TodoDurationService} Service implementation
 * 
 * @generated_by_elevenframework
 * 
 */
@Transactional
@Service("todoDurationServiceBean")
public class TodoDurationServiceImpl implements TodoDurationService {

    @Autowired
    private TodoDurationMapper todoDurationMapper;

    @Override
    public TodoDuration getTodoDurationById(int id) {
        return todoDurationMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TodoDuration> getTodoDurations(int start, int limit) {
        TodoDurationExample example = new TodoDurationExample(new TodoDuration());
        example.setLimit(start, limit);
        return todoDurationMapper.selectByExample(example);
    }

    @Override
    public List<TodoDuration> getTodoDurationsByExample(TodoDuration item, int start,
            int limit) {
        TodoDurationExample example = new TodoDurationExample(item);
        example.setLimit(start, limit);
        return todoDurationMapper.selectByExample(example);
    }
    
    @Override
    public int countByExample(TodoDuration item) {
        TodoDurationExample example = new TodoDurationExample(item);
        return todoDurationMapper.countByExample(example);
    }

    @Override
    public TodoDuration createTodoDuration(TodoDuration item) {
        todoDurationMapper.insert(item);
        return item;
    }

    @Override
    public TodoDuration updateTodoDuration(TodoDuration item) {
        todoDurationMapper.updateByPrimaryKey(item);
        return item;
    }

    @Override
    public void deleteTodoDuration(int id) {
        todoDurationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<TodoDuration> getDurationsByTodoId(Integer todoId) {
        TodoDuration todoDuration = new TodoDuration();
        todoDuration.setTodoId(todoId);
        return todoDurationMapper.selectByExample(new TodoDurationExample(todoDuration));
    }

    @Override
    public TodoDuration createDuration(Integer companyId, Integer projectId, Integer todoId, Integer userId, Date start, Date end) {
        TodoDuration todoDuration = new TodoDuration();
        todoDuration.setCompanyId(companyId);
        todoDuration.setCreatorId(userId);
        todoDuration.setEndTime(end);
        todoDuration.setProjectId(projectId);
        todoDuration.setStartTime(start);
        todoDuration.setTodoId(todoId);
        return createTodoDuration(todoDuration);
    }

    @Override
    public TodoDuration updateDuration(Integer id, Date start, Date end) {
        TodoDuration origin = getTodoDurationById(id);
        assert(origin != null);
        TodoDuration updateDuration = new TodoDuration(origin);
        updateDuration.setStartTime(start);
        updateDuration.setEndTime(end);
        return updateTodoDuration(updateDuration);
    }

    @Override
    public List<TodoDuration> getUserDurationsInCompany(Integer userId, Integer companyId) {
        TodoDuration todoDuration = new TodoDuration();
        todoDuration.setCreatorId(userId);
        todoDuration.setCompanyId(companyId);
        
        return todoDurationMapper.selectByExample(new TodoDurationExample(todoDuration));
    }

    @Override
    public List<TodoDuration> getUserDurationsInCompanyByStartTime(Integer userId, Integer companyId, Date startEarliestTime, Date startLatestTime) {
        TodoDuration todoDuration = new TodoDuration();
        todoDuration.setCreatorId(userId);
        todoDuration.setCompanyId(companyId);
        TodoDurationExample todoDurationExample = new TodoDurationExample(todoDuration);
        todoDurationExample.createCriteria().andStartTimeBetween(startEarliestTime, startLatestTime);
        
        return todoDurationMapper.selectByExample(todoDurationExample);
    }

}
