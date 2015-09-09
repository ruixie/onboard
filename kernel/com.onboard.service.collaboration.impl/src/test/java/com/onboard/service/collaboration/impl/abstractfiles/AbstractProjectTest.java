package com.onboard.service.collaboration.impl.abstractfiles;

import com.onboard.domain.model.Project;
import com.onboard.test.moduleutils.ModuleHelper;

public class AbstractProjectTest {
    public static Project getASampleProject() {
        Project project = new Project();
        project.setId(ModuleHelper.id);
        project.setCompanyId(ModuleHelper.companyId);
        project.setArchived(false);
        project.setDeleted(false);
        project.setCreated(ModuleHelper.created);
        project.setCreatorId(ModuleHelper.creatorId);
        project.setDescription(ModuleHelper.description);
        project.setName(ModuleHelper.name);
        project.setUpdated(ModuleHelper.updated);
        return project;
    }
}
