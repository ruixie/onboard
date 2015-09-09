package com.onboard.domain.transform;

import org.springframework.beans.BeanUtils;

import com.google.common.base.Function;
import com.onboard.domain.model.Project;
import com.onboard.domain.model.Step;
import com.onboard.dto.StepDTO;

public class StepTransform {

    public static final Function<Step, StepDTO> STEP_DTO_FUNCTION = new Function<Step, StepDTO>() {
        @Override
        public StepDTO apply(Step input) {
            StepDTO result = stepToStepDTO(input);
            Project project = input.getProject();
            if (project != null) {
                result.setProjectName(project.getName());
            }
            return result;
        }
    };

    public static StepDTO stepToStepDTO(Step step) {
        StepDTO stepDTO = new StepDTO();
        BeanUtils.copyProperties(step, stepDTO);
        if (step.getAssignee() != null) {
            stepDTO.setAssigneeDTO(UserTransform.userToUserDTO(step.getAssignee()));
        }
        return stepDTO;

    }
}
