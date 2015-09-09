package com.onboard.service.collaboration;

import com.onboard.domain.model.type.ProjectItem;

public interface ProjectItemService {

    ProjectItem getItemByIdInProject(Integer projectId, Integer idInProject);

}
