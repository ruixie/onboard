package com.onboard.service.collaboration;

import com.onboard.domain.model.type.ProjectItem;

public interface IdInProjectService {
    
    Integer getNextIdByProjectId(Integer projectId);
    
    Integer getNextIdByProjectIdWithStep(Integer projectId, Integer step); 
    
    ProjectItem get(Integer projectId, Integer idInProject);

}
