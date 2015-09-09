package com.onboard.service.collaboration.impl.test;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import com.onboard.domain.mapper.model.ProjectTodoIdExample;
import com.onboard.domain.model.ProjectTodoId;
import com.onboard.domain.model.type.ProjectItem;
import com.onboard.service.collaboration.impl.IdInProjectServiceImpl;
import com.onboard.test.moduleutils.ModuleHelper;

public class IdInProjectServiceImplTest extends AbstractIdInProjectServiceTest{
    
    @InjectMocks
    private IdInProjectServiceImpl idInProjectServiceImpl;
    
    @Test
    public void testGetNextIdByProjectIdWithEmptyList() {
        when(mockedProjectTodoIdMapper.selectByExample(Mockito.any(ProjectTodoIdExample.class))).thenReturn(new ArrayList<ProjectTodoId>());
        
        Integer retInt = idInProjectServiceImpl.getNextIdByProjectId(ModuleHelper.projectId);
        
        assertSame(retInt, 1);
    }
    
    @Test
    public void testGetNextIdByProjectIdWithList() {
        when(mockedProjectTodoIdMapper.selectByExample(Mockito.any(ProjectTodoIdExample.class))).thenReturn(projectTodoIdListWithOne);
        
        Integer retInt = idInProjectServiceImpl.getNextIdByProjectId(ModuleHelper.projectId);
        
        assertSame(retInt, ModuleHelper.todoId);
    }
    
    /*
    @Test
    public void testGetNextIdByProjectIdWithListMoreThanOneElement() {
        when(mockedProjectTodoIdMapper.selectByExample(Mockito.any(ProjectTodoIdExample.class))).thenReturn(projectTodoIdListWithMore);
        
        Integer retInt = idInProjectServiceImpl.getNextIdByProjectId(ModuleHelper.projectId);
        
        assertSame(retInt, 1);
    }
    */
    
    @Test
    public void testGetWithNull() {
        idInProjectServiceImpl.setProjectItemServices(projectItemServices);
        
        when(mockedProjectItemService.getItemByIdInProject(Mockito.any(Integer.class), Mockito.any(Integer.class))).thenReturn(null);
        
        ProjectItem ret = idInProjectServiceImpl.get(ModuleHelper.projectId, ModuleHelper.id);
        
        assertSame(ret, null);
    }
    
    @Test
    public void testGet() {
        idInProjectServiceImpl.setProjectItemServices(projectItemServices);
        
        when(mockedProjectItemService.getItemByIdInProject(Mockito.any(Integer.class), Mockito.any(Integer.class))).thenReturn(projectItem);
        
        ProjectItem ret = idInProjectServiceImpl.get(ModuleHelper.projectId, ModuleHelper.id);
        
        assertSame(ret, projectItem);
    }

}
