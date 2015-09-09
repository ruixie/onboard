package com.onboard.service.sampleProject.impl.test;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import com.onboard.domain.model.Discussion;
import com.onboard.domain.model.Document;
import com.onboard.domain.model.Todo;
import com.onboard.domain.model.Todolist;
import com.onboard.dto.ProjectDTO;
import com.onboard.service.sampleProject.impl.SampleProjectServiceImpl;
import com.onboard.test.exampleutils.ObjectMatcher;
import com.onboard.test.moduleutils.ModuleHelper;

public class SampleProjectServiceImplTest extends AbstractSampleProjectTest {

    @InjectMocks
    private SampleProjectServiceImpl sampleProjectServiceImpl;

    @Test
    public void testCreateSampleProjectByCompanyId() {
        sampleProjectServiceImpl.createSampleProjectByCompanyId(ModuleHelper.companyId, ModuleHelper.getASampleUser());
        verify(mockedProjectService, times(1)).createProject(Mockito.argThat(new ObjectMatcher<ProjectDTO>() {
            @Override
            public boolean verifymatches(ProjectDTO item) {
                return item.getCompanyId().equals(ModuleHelper.companyId) && item.getCreatorId().equals(ModuleHelper.userId);
            }
        }));
        verify(mockedDiscussionService, times(3)).create(Mockito.argThat(new ObjectMatcher<Discussion>() {
            @Override
            public boolean verifymatches(Discussion item) {
                return item.getCompanyId().equals(ModuleHelper.companyId) && item.getCreatorId().equals(ModuleHelper.userId) && item.getProjectId().equals(ModuleHelper.projectId) && item.getCreatorName().equals(ModuleHelper.userName);
            }
        }));
        verify(mockedTodolistService, times(2)).create(Mockito.argThat(new ObjectMatcher<Todolist>() {
            @Override
            public boolean verifymatches(Todolist item) {
                return item.getCompanyId().equals(ModuleHelper.companyId) && item.getCreatorId().equals(ModuleHelper.userId) && item.getProjectId().equals(ModuleHelper.projectId) && item.getCreatorName().equals(ModuleHelper.userName);
            }
        }));
        verify(mockedTodoService, times(4)).create(Mockito.argThat(new ObjectMatcher<Todo>() {
            @Override
            public boolean verifymatches(Todo item) {
                return item.getCompanyId().equals(ModuleHelper.companyId) && item.getCreatorId().equals(ModuleHelper.userId) && item.getProjectId().equals(ModuleHelper.projectId) && item.getCreatorName().equals(ModuleHelper.userName) && item.getTodolistId().equals(ModuleHelper.todolistId);
            }
        }));
        verify(mockedDocumentService, times(2)).create(Mockito.argThat(new ObjectMatcher<Document>() {
            @Override
            public boolean verifymatches(Document item) {
                return item.getCompanyId().equals(ModuleHelper.companyId) && item.getCreatorId().equals(ModuleHelper.userId) && item.getProjectId().equals(ModuleHelper.projectId) && item.getCreatorName().equals(ModuleHelper.userName);
            }
        }));
    }

}
