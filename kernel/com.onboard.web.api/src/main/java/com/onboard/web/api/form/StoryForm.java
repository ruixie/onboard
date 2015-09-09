package com.onboard.web.api.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.onboard.domain.model.Story;

public class StoryForm extends Story {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @NotNull
    @Min(0)
    private Integer parentStoryId;

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    @Min(0)
    private Integer priority;

    @Override
    public Integer getParentStoryId() {
        return parentStoryId;
    }

    @Override
    public void setParentStoryId(Integer parentStoryId) {
        this.parentStoryId = parentStoryId;
    }

    @Override
    public Integer getPriority() {
        return priority;
    }

    @Override
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}
