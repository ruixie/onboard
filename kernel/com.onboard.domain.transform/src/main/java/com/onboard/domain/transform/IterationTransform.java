package com.onboard.domain.transform;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.onboard.domain.model.Bug;
import com.onboard.domain.model.Iteration;
import com.onboard.domain.model.Step;
import com.onboard.domain.model.Story;
import com.onboard.domain.model.type.Iterable;
import com.onboard.dto.DTO;
import com.onboard.dto.IterationDTO;

public class IterationTransform {

    public static final Function<Iteration, IterationDTO> ITERATION_DTO_FUNCTION = new Function<Iteration, IterationDTO>() {
        @Override
        public IterationDTO apply(Iteration input) {
            return iterationToIterationDTO(input);
        }
    };

    public static IterationDTO iterationToIterationDTO(Iteration iteration) {
        IterationDTO iterationDTO = new IterationDTO();
        BeanUtils.copyProperties(iteration, iterationDTO);
        List<DTO> iterables = Lists.newArrayList();
        if (iteration.getIterables() != null) {
            for (Iterable iterable : iteration.getIterables()) {
                if (iterable instanceof Story) {
                    iterables.add(StoryTransform.storyToStoryDTO((Story) iterable));
                } else if (iterable instanceof Bug) {
                    iterables.add(BugTransForm.bugToBugDTO((Bug) iterable));
                } else if (iterable instanceof Step) {
                    iterables.add(StepTransform.stepToStepDTO((Step) iterable));
                }
            }
        }
        iterationDTO.setIterables(iterables);
        return iterationDTO;
    }

}
