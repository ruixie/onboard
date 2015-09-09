package com.onboard.domain.transform;

import org.springframework.beans.BeanUtils;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.onboard.domain.model.Story;
import com.onboard.dto.StoryDTO;

public class StoryTransform {

    public static final Function<Story, StoryDTO> STORY_DTO_FUNCTION = new Function<Story, StoryDTO>() {
        @Override
        public StoryDTO apply(Story input) {
            return storyToStoryDTO(input);
        }
    };

    public static StoryDTO storyToStoryDTO(Story story) {
        StoryDTO storyDTO = new StoryDTO();
        BeanUtils.copyProperties(story, storyDTO);
        if (story.getChildStories() != null) {
            storyDTO.setChildStoryDTOs(Lists.newArrayList(Lists.transform(story.getChildStories(),
                    StoryTransform.STORY_DTO_FUNCTION)));
        }
        return storyDTO;
    }

    public static Function<Story, StoryDTO> getStoryDtoFunction() {
        return StoryTransform.STORY_DTO_FUNCTION;
    }
}
