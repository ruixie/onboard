package com.onboard.web.api.todo;

import java.util.Date;
import java.util.List;

import org.elevenframework.web.interceptor.Interceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.onboard.domain.model.TodoDuration;
import com.onboard.service.collaboration.TodoDurationService;
import com.onboard.service.security.interceptors.ProjectMemberRequired;
import com.onboard.service.web.SessionService;

@RequestMapping(value = "/{companyId}/projects/{projectId}/todos/{todoId}/durations")
@Controller
public class TodoDuartionApiController {

    @Autowired
    private TodoDurationService todoDurationService;

    @Autowired
    private SessionService sessionService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Interceptors({ ProjectMemberRequired.class })
    @ResponseBody
    public List<TodoDuration> getTodoDurations(@PathVariable int todoId) {
        return todoDurationService.getDurationsByTodoId(todoId);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @Interceptors({ ProjectMemberRequired.class })
    @ResponseBody
    public TodoDuration createTodoDuration(@PathVariable int companyId, @PathVariable int projectId, @PathVariable int todoId,
            @RequestParam(value = "start", required = true) Long start, @RequestParam(value = "end", required = true) Long end) {
        Date startTime = new Date(start);
        Date endTime = new Date(end);
        return todoDurationService.createDuration(companyId, projectId, todoId, sessionService.getCurrentUser().getId(),
                startTime, endTime);
    }

    @RequestMapping(value = "/{todoDurationId}", method = RequestMethod.PUT)
    @Interceptors({ ProjectMemberRequired.class })
    @ResponseBody
    public TodoDuration updateTodoDuration(@PathVariable int todoDurationId,
            @RequestParam(value = "start", required = true) Long start, @RequestParam(value = "end", required = true) Long end) {
        Date startTime = new Date(start);
        Date endTime = new Date(end);
        return todoDurationService.updateDuration(todoDurationId, startTime, endTime);
    }

    @RequestMapping(value = "/{todoDurationId}", method = RequestMethod.DELETE)
    @Interceptors({ ProjectMemberRequired.class })
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteTodoDuration(@PathVariable int todoDurationId) {
        todoDurationService.deleteTodoDuration(todoDurationId);
    }

}
