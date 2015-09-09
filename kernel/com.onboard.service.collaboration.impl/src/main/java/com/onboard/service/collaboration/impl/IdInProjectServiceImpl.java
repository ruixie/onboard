package com.onboard.service.collaboration.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.onboard.domain.mapper.ProjectTodoIdMapper;
import com.onboard.domain.mapper.model.ProjectTodoIdExample;
import com.onboard.domain.model.ProjectTodoId;
import com.onboard.domain.model.type.ProjectItem;
import com.onboard.service.collaboration.IdInProjectService;
import com.onboard.service.collaboration.ProjectItemService;

@Service("idInProjectServiceImplBean")
public class IdInProjectServiceImpl implements IdInProjectService {
    
    @Autowired
    private ProjectTodoIdMapper projectTodoIdMapper;
    
    @Autowired
    private List<ProjectItemService> projectItemServices;
    
//    public synchronized void addProjectItemService(ProjectItemService projectItemService) {
//        if (projectItemService != null && !projectItemServices.contains(projectItemService)) {
//            projectItemServices.add(projectItemService);
//        }
//    }
//    
//    public synchronized void removeProjectItemService(ProjectItemService projectItemService) {
//        if (projectItemService != null && projectItemServices.contains(projectItemService)) {
//            projectItemServices.remove(projectItemService);
//        }
//    }

    public List<ProjectItemService> getProjectItemServices() {
        return projectItemServices;
    }

    public void setProjectItemServices(List<ProjectItemService> projectItemServices) {
        this.projectItemServices = projectItemServices;
    }

    @Override
    public Integer getNextIdByProjectId(Integer projectId) {
        return getNextIdByProjectIdWithStep(projectId, 1);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public synchronized Integer getNextIdByProjectIdWithStep(Integer projectId, Integer step) {
        ProjectTodoId sample = new ProjectTodoId();
        sample.setProjectId(projectId);
        List<ProjectTodoId> result = projectTodoIdMapper.selectByExample(new ProjectTodoIdExample(sample));
        if (result.isEmpty()) {
            sample.setTodoId(step + 1);
            projectTodoIdMapper.insert(sample);
            return 1;
        } else {
            assert (result.size() == 1);
            int todoId = result.get(0).getTodoId();
            ProjectTodoId newId = new ProjectTodoId(result.get(0));
            newId.setTodoId(todoId + step);
            projectTodoIdMapper.updateByPrimaryKey(newId);
            return todoId;
        }
    }

    @Override
    public ProjectItem get(Integer projectId, Integer idInProject) {
        for (ProjectItemService projectItemService : projectItemServices) {
            ProjectItem projectItem = projectItemService.getItemByIdInProject(projectId, idInProject);
            if(projectItem != null){
                return projectItem;
            }
        }
        return null;
    }
    

}
