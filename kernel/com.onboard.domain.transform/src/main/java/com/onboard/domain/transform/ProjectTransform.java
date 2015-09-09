package com.onboard.domain.transform;

import org.springframework.beans.BeanUtils;

import com.google.common.base.Function;
import com.onboard.domain.model.Project;
import com.onboard.dto.ProjectDTO;

public class ProjectTransform {

    public static final Function<Project, ProjectDTO> PROJECT_DTO_FUNCTION = new Function<Project, ProjectDTO>() {
        @Override
        public ProjectDTO apply(Project input) {
            return projectToProjectDTO(input);
        }
    };

    public static ProjectDTO projectToProjectDTO(Project project) {
        ProjectDTO projectDTO = new ProjectDTO();
        BeanUtils.copyProperties(project, projectDTO);
        return projectDTO;
    }

    public static Project projectDTOtoProject(ProjectDTO projectDTO) {
        Project project = new Project();
        BeanUtils.copyProperties(projectDTO, project);

        return project;
    }
}
