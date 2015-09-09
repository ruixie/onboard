package com.onboard.service.collaboration.activity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.InjectMocks;

import com.onboard.domain.model.Activity;
import com.onboard.domain.model.type.BaseProjectItem;
import com.onboard.service.activity.ActivityActionType;
import com.onboard.test.moduleutils.ModuleHelper;

public class TodolistActivityGeneratorTest extends AbstractTodolistActivityGenerator{
    @InjectMocks
    private TodolistActivityGenerator todolistActivityGenerator;
    
    @Test
    public void testModelType() {
        String ret = todolistActivityGenerator.modelType();
        assertEquals(ret, "todolist");
    }
    
    @Test
    public void testGenerateCreateActivity() {
        Activity ret = todolistActivityGenerator.generateCreateActivity(todolist);
        assertEquals(ret.getAction(), ActivityActionType.CREATE);
        assertEquals(ret.getCompanyId(), new Integer(ModuleHelper.companyId));
        assertEquals(ret.getProjectId(), new Integer(ModuleHelper.projectId));
        
        ret = todolistActivityGenerator.generateCreateActivity(todolistWithTodos);
        assertEquals(ret.getAction(), ActivityActionType.COPY);
        assertEquals(ret.getCompanyId(), new Integer(ModuleHelper.companyId));
        assertEquals(ret.getProjectId(), new Integer(ModuleHelper.projectId));
    }
    
    @Test
    public void testGenerateUpdateActivity() {
        Activity ret;
        ret = todolistActivityGenerator.generateUpdateActivity(todolist, todolistDeleted);
        assertEquals(ret.getAction(), ActivityActionType.DISCARD);
        ret = todolistActivityGenerator.generateUpdateActivity(todolistDeleted, todolist);
        assertEquals(ret.getAction(), ActivityActionType.RECOVER);
        ret = todolistActivityGenerator.generateUpdateActivity(todolist, todolistArchived);
        assertEquals(ret.getAction(), ActivityActionType.ARCHIVE);
        ret = todolistActivityGenerator.generateUpdateActivity(todolistArchived, todolist);
        assertEquals(ret.getAction(), ActivityActionType.ACTIVATE);
        ret = todolistActivityGenerator.generateUpdateActivity(todolist, todolistMoved);
        assertEquals(ret.getAction(), ActivityActionType.RELOCATE);
        ret = todolistActivityGenerator.generateUpdateActivity(todolist, todolistName);
        assertEquals(ret.getAction(), ActivityActionType.UPDATE);
        assertEquals(ret.getContent(), String.format(TodolistActivityGenerator.NAME_UPDATE, todolist.getName(), todolistName.getName()));
        ret = todolistActivityGenerator.generateUpdateActivity(todolist, todolistDescription);
        assertEquals(ret.getAction(), ActivityActionType.UPDATE);
        assertEquals(ret.getContent(), String.format(TodolistActivityGenerator.DESCRIPTION_UPDATE, todolist.getDescription(), todolistDescription.getDescription()));
        ret = todolistActivityGenerator.generateUpdateActivity(todolist, todolistNameAndDescription);
        assertEquals(ret.getAction(), ActivityActionType.UPDATE);
        assertEquals(ret.getContent(), String.format(TodolistActivityGenerator.NAME_AND_DESCRIPTION_UPDATE, todolist.getName(), todolistNameAndDescription.getName(),
                todolist.getDescription(), todolistNameAndDescription.getDescription()));
    }
    
    @Test
    public void testEnrichModel() {
        BaseProjectItem ret = todolistActivityGenerator.enrichModel(todolist);
        verify(mockedTodolistService, times(1)).getById(anyInt());
        assertEquals(ret.getId(), new Integer(ModuleHelper.todolistId));
        assertEquals(ret.getCompanyId(), new Integer(ModuleHelper.companyId));
        assertEquals(ret.getCreatorId(), new Integer(ModuleHelper.creatorId));
        assertEquals(ret.getProjectId(), new Integer(ModuleHelper.projectId));
        assertEquals(ret.getCreatorName(), ModuleHelper.creatorName);
    }
    
    @Test
    public void testModelService() {
        String ret = todolistActivityGenerator.modelType();
        assertEquals(ret, "todolist");
    }
}
