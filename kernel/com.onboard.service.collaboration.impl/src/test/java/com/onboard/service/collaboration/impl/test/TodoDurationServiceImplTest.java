/*******************************************************************************
 * Copyright [2015] [Onboard team of SERC, Peking University]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.onboard.service.collaboration.impl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import com.onboard.domain.mapper.model.TodoDurationExample;
import com.onboard.domain.mapper.model.common.BaseExample;
import com.onboard.domain.model.TodoDuration;
import com.onboard.service.collaboration.impl.TodoDurationServiceImpl;
import com.onboard.test.exampleutils.CriterionVerifier;
import com.onboard.test.exampleutils.ExampleMatcher;
import com.onboard.test.moduleutils.ModuleHelper;

public class TodoDurationServiceImplTest extends AbstractTodoDurationServiceTest {
    @InjectMocks
    private TodoDurationServiceImpl todoDurationServiceImpl;
    
    @Test
    public void testGetTodoDurationById() {
        TodoDuration ret = todoDurationServiceImpl.getTodoDurationById(ModuleHelper.todoId);
        verify(mockedTodoDurationMapper, times(1)).selectByPrimaryKey(anyInt());
        assertSame(ret, todoDuration);
    }
    
    @Test
    public void testGetTodoDurations() {
        List<TodoDuration> ret = todoDurationServiceImpl.getTodoDurations(ModuleHelper.start, ModuleHelper.limit);
        verify(mockedTodoDurationMapper, times(1)).selectByExample(Mockito.argThat(new ExampleMatcher<TodoDurationExample>() {
            @Override
            public boolean matches(BaseExample example) {
                return example.getStart() == ModuleHelper.start && example.getLimit() == ModuleHelper.limit;
            }
        }));
        assertEquals(ret.size(), 2);
        assertEquals(ret.get(0).getId(), new Integer(ModuleHelper.id));
    }
    
    @Test
    public void testGetTodoDurationsByExample() {
        List<TodoDuration> ret = todoDurationServiceImpl.getTodoDurationsByExample(todoDuration, ModuleHelper.start, ModuleHelper.limit);
        verify(mockedTodoDurationMapper, times(1)).selectByExample(Mockito.argThat(new ExampleMatcher<TodoDurationExample>() {
            @Override
            public boolean matches(BaseExample example) {
                return example.getStart() == ModuleHelper.start && example.getLimit() == ModuleHelper.limit;
            }
        }));
        assertEquals(ret.size(), 2);
        assertEquals(ret.get(0).getId(), new Integer(ModuleHelper.id));
    }
    
    @Test
    public void testCountByExample() {
        int ret = todoDurationServiceImpl.countByExample(todoDuration);
        verify(mockedTodoDurationMapper, times(1)).countByExample(Mockito.any(TodoDurationExample.class));
        assertEquals(ret, ModuleHelper.count);
    }
    
    @Test
    public void testCreateTodoDuration() {
        TodoDuration ret = todoDurationServiceImpl.createTodoDuration(todoDuration);
        verify(mockedTodoDurationMapper, times(1)).insert(Mockito.any(TodoDuration.class));
        assertSame(ret, todoDuration);
    }
    
    @Test
    public void testUpdateTodoDuration() {
        TodoDuration ret = todoDurationServiceImpl.updateTodoDuration(todoDuration);
        verify(mockedTodoDurationMapper, times(1)).updateByPrimaryKey(Mockito.any(TodoDuration.class));
        assertSame(ret, todoDuration);
    }
    
    @Test
    public void testDeleteTodoDuration() {
        todoDurationServiceImpl.deleteTodoDuration(ModuleHelper.id);
        verify(mockedTodoDurationMapper, times(1)).deleteByPrimaryKey(anyInt());
    }
    
    @Test
    public void testGetDurationsByTodoId() {
        List<TodoDuration> ret = todoDurationServiceImpl.getDurationsByTodoId(ModuleHelper.todoId);
        verify(mockedTodoDurationMapper, times(1)).selectByExample(Mockito.argThat(new ExampleMatcher<TodoDurationExample>() {
            @Override
            public boolean matches(BaseExample example) {
                return CriterionVerifier.verifyEqualTo(example, "todoId", ModuleHelper.todoId);
            }
        }));
        assertEquals(ret.size(), 2);
        assertEquals(ret.get(0).getId(), new Integer(ModuleHelper.id));
    }
    
    @Test
    public void testCreateDuration() {
        TodoDuration ret = todoDurationServiceImpl.createDuration(ModuleHelper.companyId, ModuleHelper.projectId, ModuleHelper.todoId, ModuleHelper.userId, new Date(), new Date());
        assertEquals(ret.getCompanyId(), new Integer(ModuleHelper.companyId));
        assertEquals(ret.getProjectId(), new Integer(ModuleHelper.projectId));
        assertEquals(ret.getTodoId(), new Integer(ModuleHelper.todoId));
        assertEquals(ret.getCreatorId(), new Integer(ModuleHelper.userId));
    }
    
    @Test
    public void testUpdateDuration() {
        TodoDuration ret = todoDurationServiceImpl.updateDuration(ModuleHelper.id, new Date(), new Date());
        assertEquals(ret.getId(), todoDuration.getId());
    }
    
    @Test
    public void testGetUserDurationsInCompany() {
        List<TodoDuration> ret = todoDurationServiceImpl.getUserDurationsInCompany(ModuleHelper.userId, ModuleHelper.companyId);
        verify(mockedTodoDurationMapper, times(1)).selectByExample(Mockito.argThat(new ExampleMatcher<TodoDurationExample>() {
            @Override
            public boolean matches(BaseExample example) {
                return CriterionVerifier.verifyEqualTo(example, "creatorId", ModuleHelper.userId) && CriterionVerifier.verifyEqualTo(example, "companyId", ModuleHelper.companyId);
            }
        }));
        assertEquals(ret.size(), 2);
        assertEquals(ret.get(0).getId(), new Integer(ModuleHelper.id));
    }
    
    @Test 
    public void testGetUserDurationsInCompanyByStartTime() {
        List<TodoDuration> ret = todoDurationServiceImpl.getUserDurationsInCompanyByStartTime(ModuleHelper.userId, ModuleHelper.companyId, new Date(), new Date());
        verify(mockedTodoDurationMapper, times(1)).selectByExample(Mockito.argThat(new ExampleMatcher<TodoDurationExample>() {
            @Override
            public boolean matches(BaseExample example) {
                return CriterionVerifier.verifyEqualTo(example, "creatorId", ModuleHelper.userId) && CriterionVerifier.verifyEqualTo(example, "companyId", ModuleHelper.companyId);
            }
        }));
        assertEquals(ret.size(), 2);
        assertEquals(ret.get(0).getId(), new Integer(ModuleHelper.id));
    }
}


