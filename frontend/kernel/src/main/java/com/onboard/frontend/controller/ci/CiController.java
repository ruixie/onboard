package com.onboard.frontend.controller.ci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.onboard.frontend.service.net.NetService;

@Controller
public class CiController {
    private final static String CIURI = "/ciProjects/%s/%s";
    @Autowired
    private NetService netService;

    @RequestMapping(value = "/ciProjects/{jobName}/{buildNumber}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void responseJenkinsAndSaveBuildResult(@PathVariable String jobName, @PathVariable String buildNumber) {

        netService.getForObject(String.format(CIURI, jobName, buildNumber), null);
    }
}
