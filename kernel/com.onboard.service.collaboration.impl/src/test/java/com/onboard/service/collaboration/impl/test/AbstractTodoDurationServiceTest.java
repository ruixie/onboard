package com.onboard.service.collaboration.impl.test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.onboard.domain.mapper.TodoDurationMapper;
import com.onboard.domain.mapper.model.TodoDurationExample;
import com.onboard.domain.model.TodoDuration;
import com.onboard.test.moduleutils.ModuleHelper;

@RunWith(MockitoJUnitRunner.class)
public abstract class AbstractTodoDurationServiceTest {
    
    @Mock
    protected TodoDurationMapper mockedTodoDurationMapper;
    
    protected TodoDuration todoDuration;
    protected List<TodoDuration> todoDurationList;
    
    @Before
    public void setupTest() {
        initTodoDurationMapper();
    }
    
    /** initTodoDurationMapper **/
    private void initTodoDurationMapper() {
        todoDuration = getASampleTodoDuration();
        todoDurationList = getAListOfSampleTodoDuration();
        
        when(mockedTodoDurationMapper.selectByPrimaryKey(anyInt())).thenReturn(todoDuration);
        when(mockedTodoDurationMapper.selectByExample(Mockito.any(TodoDurationExample.class))).thenReturn(todoDurationList);
        when(mockedTodoDurationMapper.countByExample(Mockito.any(TodoDurationExample.class))).thenReturn(ModuleHelper.count);
        when(mockedTodoDurationMapper.insert(Mockito.any(TodoDuration.class))).thenReturn(1);
        when(mockedTodoDurationMapper.updateByPrimaryKey(Mockito.any(TodoDuration.class))).thenReturn(1);
        when(mockedTodoDurationMapper.deleteByPrimaryKey(anyInt())).thenReturn(1);
        
    }
    
    private TodoDuration getASampleTodoDuration() {
        TodoDuration td = new TodoDuration();
        td.setId(ModuleHelper.id);
        return td;
    }
    
    private List<TodoDuration> getAListOfSampleTodoDuration() {
        List<TodoDuration> list = new ArrayList<TodoDuration>();
        list.add(getASampleTodoDuration());
        list.add(getASampleTodoDuration());
        return list;
    }
}
