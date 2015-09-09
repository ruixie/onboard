package com.onboard.web.api.topic;

import org.elevenframework.web.interceptor.Interceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onboard.domain.model.Topic;
import com.onboard.service.collaboration.TopicService;
import com.onboard.service.security.exception.NoPermissionException;
import com.onboard.service.security.interceptors.ProjectMemberRequired;

@RequestMapping(value = "/{companyId}/projects/{projectId}")
@Controller
public class TopicAPIController {

    @Autowired
    private TopicService topicService;

    @RequestMapping(value = "/topics/{topicId}/stick", method = RequestMethod.PUT)
    @Interceptors({ ProjectMemberRequired.class })
    @ResponseBody
    public Topic stickTopic(@PathVariable int topicId, @PathVariable int projectId) {
        int stickCount = topicService.getTopicCount(projectId);
        if (stickCount > 10) {
            throw new NoPermissionException();
        }
        return topicService.stickTopic(topicId);

    }

    @RequestMapping(value = "/topics/{topicId}/unstick", method = RequestMethod.PUT)
    @Interceptors({ ProjectMemberRequired.class })
    @ResponseBody
    public Topic unstickTopic(@PathVariable int topicId) {

        return topicService.unstickTopic(topicId);

    }

    @RequestMapping(value = "/topics-stick-count", method = RequestMethod.GET)
    @Interceptors({ ProjectMemberRequired.class })
    @ResponseBody
    public Integer getStickTopicCount(@PathVariable int projectId) {

        return topicService.getTopicCount(projectId);

    }
}
