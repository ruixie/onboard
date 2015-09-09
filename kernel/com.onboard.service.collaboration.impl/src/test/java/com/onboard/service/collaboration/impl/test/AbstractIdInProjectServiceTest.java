package com.onboard.service.collaboration.impl.test;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.onboard.domain.mapper.ProjectTodoIdMapper;
import com.onboard.domain.model.ProjectTodoId;
import com.onboard.domain.model.type.ProjectItem;
import com.onboard.service.collaboration.ProjectItemService;
import com.onboard.test.moduleutils.ModuleHelper;

@RunWith(MockitoJUnitRunner.class)
public abstract class AbstractIdInProjectServiceTest {

    @Mock
    protected ProjectTodoIdMapper mockedProjectTodoIdMapper;
    
    @Mock
    protected ProjectItemService mockedProjectItemService;
    
    @Mock
    protected Iterator<ProjectItemService> mockedIterator;
    
    protected List<ProjectTodoId> projectTodoIdListWithOne, projectTodoIdListWithMore;
    protected List<ProjectItemService> projectItemServices;
    protected ProjectItem projectItem;
    
    @Before
    public void setupTest() {
        initProjectTodoIdMapper();
        initProjectItemServices();
        projectTodoIdListWithOne = getAListOfProjectTodoId(1);
        projectTodoIdListWithMore = getAListOfProjectTodoId(3);
    }
    
    /** initProjectTodoIdMapper **/
    private void initProjectTodoIdMapper() {
        when(mockedProjectTodoIdMapper.insert(Mockito.any(ProjectTodoId.class))).thenReturn(0);
        when(mockedProjectTodoIdMapper.updateByPrimaryKey(Mockito.any(ProjectTodoId.class))).thenReturn(0);
        
        return ;
    }
    
    /** initProjectItemServices **/
    private void initProjectItemServices() {
        projectItemServices = new ArrayList<ProjectItemService>();
        projectItemServices.add(mockedProjectItemService);
    }
    
    /** **/
    private List<ProjectTodoId> getAListOfProjectTodoId(int n) {
        List<ProjectTodoId> list = new ArrayList<ProjectTodoId>();
        for (int i = 0; i < n; ++i) {
            ProjectTodoId projectTodoId = new ProjectTodoId(ModuleHelper.id);
            projectTodoId.setTodoId(ModuleHelper.todoId);
            list.add(projectTodoId);
        }
        return list;
    }
}
