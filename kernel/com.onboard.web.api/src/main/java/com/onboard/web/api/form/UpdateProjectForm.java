package com.onboard.web.api.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.onboard.dto.ProjectDTO;

public class UpdateProjectForm extends ProjectDTO {

    public UpdateProjectForm() {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Length(min = 1, max = 50)
    @NotBlank
    @NotNull
    private String name;

    @Length(max = 500)
    private String description;

}
