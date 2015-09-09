package com.onboard.service.collaboration.activity;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.onboard.domain.model.Project;
import com.onboard.service.collaboration.ProjectService;
import com.onboard.test.moduleutils.ModuleHelper;

@RunWith(MockitoJUnitRunner.class)
public abstract class AbstractProjectActivityGenerator {
    @Mock
    protected ProjectService mockedProjectService;
    
    protected Project project, projectDeleted, projectArchive, projectName, projectDescription, projectNameAndDescription;
    
    @Before
    public void setupTest() {
        project = ModuleHelper.getASampleProject();
        project.setArchived(false);
        projectDeleted = ModuleHelper.getASampleProject();
        projectDeleted.setDeleted(true);
        projectArchive = ModuleHelper.getASampleProject();
        projectArchive.setArchived(true);
        projectName = ModuleHelper.getASampleProject();
        projectName.setName(ModuleHelper.name + "1");
        projectDescription = ModuleHelper.getASampleProject();
        projectDescription.setDescription(ModuleHelper.description + "1");
        projectNameAndDescription = ModuleHelper.getASampleProject();
        projectNameAndDescription.setName(ModuleHelper.name + "1");
        projectNameAndDescription.setDescription(ModuleHelper.description + "1");
        initProjectService();
    }
    
    /** initProjectService **/
    private void initProjectService() {
        when(mockedProjectService.getById(anyInt())).thenReturn(project);
    }
}
