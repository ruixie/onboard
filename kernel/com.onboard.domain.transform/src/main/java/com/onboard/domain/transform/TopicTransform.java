package com.onboard.domain.transform;

import org.springframework.beans.BeanUtils;

import com.google.common.base.Function;
import com.onboard.domain.model.Topic;
import com.onboard.dto.TopicDTO;

public class TopicTransform {

    public static final Function<Topic, TopicDTO> TOPIC_DTO_FUNCTION = new Function<Topic, TopicDTO>() {
        @Override
        public TopicDTO apply(Topic topic) {
            return topicToTopicDTO(topic);
        }
    };

    public static TopicDTO topicToTopicDTO(Topic topic) {
        TopicDTO topicDTO = new TopicDTO();
        BeanUtils.copyProperties(topic, topicDTO);
        if (topic.getLastUpdator() != null) {
            topicDTO.setUpdator(UserTransform.userToUserDTO(topic.getLastUpdator()));
        }
        if (topic.getTargetCreator() != null) {
            topicDTO.setUpdator(UserTransform.userToUserDTO(topic.getLastUpdator()));
        }
        return topicDTO;
    }

}
