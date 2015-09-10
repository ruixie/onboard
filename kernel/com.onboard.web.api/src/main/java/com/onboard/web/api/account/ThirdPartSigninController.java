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
package com.onboard.web.api.account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onboard.domain.model.GithubInfo;
import com.onboard.domain.model.GithubUser;
import com.onboard.domain.model.User;
import com.onboard.domain.transform.UserTransform;
import com.onboard.dto.UserDTO;
import com.onboard.service.account.UserService;
import com.onboard.service.github.GithubInfoService;
import com.onboard.service.github.GithubService;
import com.onboard.service.github.utils.GitHubUtil;

@Controller
public class ThirdPartSigninController {

    public static final Logger logger = LoggerFactory.getLogger(ThirdPartSigninController.class);
    public static final String SIGNIN_VIEW = "account/Signin";

    @Autowired
    private GithubService githubService;

    @Autowired
    private GithubInfoService githubInfoService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signin/github/callback", method = RequestMethod.GET)
    @ResponseBody
    public UserDTO getGitHubResponse(@RequestParam("code") String code, HttpServletRequest request,
            HttpServletResponse response) {
        User user = new User();
        GithubInfo githubInfo = new GithubInfo();
        try {
            // String token = GitHubUtil.getAccessToken(code);
            GithubUser githubUser = githubService.getGithubUserByOAuth(GitHubUtil.getAccessToken(code));
            githubInfo.setUserId(Integer.valueOf(githubUser.getId()));
            List<GithubInfo> githubInfos = githubInfoService.getGithubInfosByExample(githubInfo, 0, -1);
            if (githubInfos.size() == 0) {
                user.setEmail(githubUser.getEmail());
                return UserTransform.userToUserDTO(user);
            }
            // 从数据库中获取
            githubInfo = githubInfos.get(0);
            user = userService.getById(githubInfo.getOnboardUserId());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return UserTransform.userToUserDTO(user);
    }

}
