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

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.Lists;
import com.onboard.domain.mapper.IterationAttachMapper;
import com.onboard.domain.mapper.IterationMapper;
import com.onboard.domain.mapper.ProjectMapper;
import com.onboard.domain.mapper.base.BaseMapper;
import com.onboard.domain.mapper.model.IterationExample;
import com.onboard.domain.mapper.model.common.BaseExample;
import com.onboard.domain.model.Iteration;
import com.onboard.domain.model.Iteration.IterationStatus;
import com.onboard.service.base.BaseService;
import com.onboard.service.collaboration.ProjectService;
import com.onboard.service.collaboration.impl.IterationServiceImpl;
import com.onboard.service.common.identifiable.IdentifiableManager;
import com.onboard.test.exampleutils.CriterionVerifier;
import com.onboard.test.exampleutils.ExampleMatcher;
import com.onboard.test.moduleutils.ModuleHelper;
import com.onboard.test.service.AbstractProjectItemServiceTest;

@RunWith(MockitoJUnitRunner.class)
public class IterationServiceImplTest extends AbstractProjectItemServiceTest<Iteration, IterationExample> {

    @InjectMocks IterationServiceImpl testedIterationServiceImpl;
    
    @Mock IterationMapper iterationMapper;
    @Mock IterationAttachMapper iterationAttachMapper;
    @Mock IdentifiableManager identifiableManager;
    @Mock ProjectMapper projectMapper;
    @Mock ProjectService projectService;

    public static Date startTime = ModuleHelper.getDateByString("2014-05-30 00:00");
    public static Date endTime = ModuleHelper.getDateByString("2014-08-30 00:00");
    
    @Override
    protected BaseMapper<Iteration, IterationExample> getMockMapper() {
        return iterationMapper;
    }

    @Override
    protected BaseService<Iteration, IterationExample> getTestService() {
        return testedIterationServiceImpl;
    }

    @Override
    protected Iteration getSample() {
        Iteration iteration = super.getSample();
        iteration.setEndTime(endTime);
        iteration.setStartTime(startTime);
        iteration.setStatus(IterationStatus.CREATED.getValue());
        return iteration;
    }
    
    @Test
    public void updateSelectiveWhitEndTime() {
        Iteration sample = getSample(ModuleHelper.id);
        DateTime now = DateTime.now();
        sample.setEndTime(now.toDate());
        
        Iteration result = getTestService().updateSelective(sample);
        
        assertEquals(now.withTimeAtStartOfDay().plusDays(1).plusSeconds(-1).toDate(), result.getEndTime());
    }
    
    @Test
    public void updateSelectiveToCompleteIteration() {
        Iteration sample = getSample(ModuleHelper.id);
        sample.setStatus(IterationStatus.COMPLETED.getValue());
        
        Iteration result = getTestService().updateSelective(sample);
        
        assertEquals(IterationStatus.COMPLETED.getValue(), result.getStatus());
        assertNow(result.getEndTime());
        //TODO: add new iteration to project
    }
    
    @Test
    public void getCurrentIterationByProjectId(){
        Iteration result = testedIterationServiceImpl.getCurrentIterationByProjectId(ModuleHelper.projectId);
        
        verify(getMockMapper()).selectByExample(Mockito.argThat(new ExampleMatcher<IterationExample>() {
            @Override
            public boolean matches(BaseExample example) {
                return CriterionVerifier.verifyEqualTo(example, "projectId", ModuleHelper.projectId)
                        && CriterionVerifier.verifyIn(example, "status", Lists.newArrayList(IterationStatus.ACTIVE.getValue(), IterationStatus.CREATED.getValue()));
            }
        }));
        assertEquals((int)result.getProjectId(), ModuleHelper.projectId);
    }
    
    @Test
    public void getCurrentIterationByProjectIdEmpty(){
        when(iterationMapper.selectByExample(Mockito.any(IterationExample.class))).thenReturn(new ArrayList<Iteration>());
        Iteration result = testedIterationServiceImpl.getCurrentIterationByProjectId(ModuleHelper.projectId);
        assertNull(result);
    }

}
