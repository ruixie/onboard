package com.onboard.service.collaboration.activity;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.onboard.domain.model.Project;
import com.onboard.domain.model.Todo;
import com.onboard.domain.model.Todolist;
import com.onboard.service.collaboration.ProjectService;
import com.onboard.service.collaboration.TodolistService;
import com.onboard.test.moduleutils.ModuleHelper;

@RunWith(MockitoJUnitRunner.class)
public abstract class AbstractTodolistActivityGenerator {
    @Mock
    protected TodolistService mockedTodolistService;
    
    protected Todolist todolist, todolistWithTodos, todolistArchived, todolistDeleted, todolistMoved, todolistName, todolistDescription, todolistNameAndDescription;

    protected static ProjectService projectService;
    protected Project project;
    
    @Before
    public void setupTest() {
        todolist = getASampleTodolist();
        todolistMoved = getASampleTodolist();
        todolistMoved.setProjectId(ModuleHelper.projectId + 1);
        todolistWithTodos = getASampleTodolist();
        todolistWithTodos.setTodos(getAListOfSampleTodos());
        todolistDeleted = getASampleTodolist();
        todolistDeleted.setDeleted(true);
        todolistArchived = getASampleTodolist();
        todolistArchived.setArchived(true);
        todolistName = getASampleTodolist();
        todolistName.setName(ModuleHelper.name+"1");
        todolistDescription = getASampleTodolist();
        todolistDescription.setDescription(ModuleHelper.description+"1");
        todolistNameAndDescription = getASampleTodolist();
        todolistNameAndDescription.setName(ModuleHelper.name+"1");
        todolistNameAndDescription.setDescription(ModuleHelper.description+"1");
        
        project = ModuleHelper.getASampleProject();
        projectService = Mockito.mock(ProjectService.class);
        when(projectService.getById(anyInt())).thenReturn(project);
        ActivityRecorderHelper.setProjectService(projectService);
        initTodolistService();
    }
    
    /** initTodolistService **/
    private void initTodolistService() {
        when(mockedTodolistService.getById(anyInt())).thenReturn(todolist);
    }
    
    private Todolist getASampleTodolist() {
        Todolist tl = new Todolist();
        tl.setId(ModuleHelper.todolistId);
        tl.setProjectId(ModuleHelper.projectId);
        tl.setCompanyId(ModuleHelper.companyId);
        tl.setCreatorId(ModuleHelper.creatorId);
        tl.setCreatorName(ModuleHelper.creatorName);
        tl.setArchived(false);
        tl.setDeleted(false);
        return tl;
    }
    
    private List<Todo> getAListOfSampleTodos() {
        List<Todo> list = new ArrayList<Todo>();
        list.add(ModuleHelper.getASampleTodo());
        list.add(ModuleHelper.getASampleTodo());
        return list;
    }
}
