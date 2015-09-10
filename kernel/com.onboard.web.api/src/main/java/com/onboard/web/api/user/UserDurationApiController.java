/*******************************************************************************
 * Copyright [2015] [Onboard team of SERC, Peking University]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.onboard.web.api.user;

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
import com.onboard.service.security.interceptors.CompanyMemberRequired;
import com.onboard.service.web.SessionService;

@RequestMapping(value = "/{companyId}/users/{userId}/durations")
@Controller
public class UserDurationApiController {

    @Autowired
    private TodoDurationService todoDurationService;

    @Autowired
    private SessionService sessionService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Interceptors({ CompanyMemberRequired.class })
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public List<TodoDuration> getUserDurations(@PathVariable int userId, @PathVariable int companyId,
            @RequestParam(value = "start", required = true) Long start, @RequestParam(value = "end", required = true) Long end) {
        Date startTime = new Date(start);
        Date endTime = new Date(end);

        return todoDurationService.getUserDurationsInCompanyByStartTime(userId, companyId, startTime, endTime);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @Interceptors({ CompanyMemberRequired.class })
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public void createUserDuration(@PathVariable int userId, @PathVariable int companyId,
            @RequestParam(value = "start", required = true) Long start, @RequestParam(value = "end", required = true) Long end) {
        Date startTime = new Date(start);
        Date endTime = new Date(end);
        TodoDuration duration = new TodoDuration();
        duration.setCompanyId(companyId);
        duration.setCreatorId(sessionService.getCurrentUser().getId());
        duration.setStartTime(startTime);
        duration.setEndTime(endTime);
        todoDurationService.createTodoDuration(duration);
    }

    @RequestMapping(value = "/{todoDurationId}", method = RequestMethod.DELETE)
    @Interceptors({ CompanyMemberRequired.class })
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public void updateUserDuration(@PathVariable int todoDurationId) {
        todoDurationService.deleteTodoDuration(todoDurationId);
    }

    @RequestMapping(value = "/{todoDurationId}", method = RequestMethod.PUT)
    @Interceptors({ CompanyMemberRequired.class })
    @ResponseBody
    public TodoDuration updateTodoDuration(@PathVariable int todoDurationId,
            @RequestParam(value = "start", required = true) Long start, @RequestParam(value = "end", required = true) Long end) {
        Date startTime = new Date(start);
        Date endTime = new Date(end);
        return todoDurationService.updateDuration(todoDurationId, startTime, endTime);
    }

}
