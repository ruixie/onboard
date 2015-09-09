package com.onboard.web.api.account;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onboard.domain.model.GithubInfo;
import com.onboard.domain.model.GithubUser;
import com.onboard.domain.model.User;
import com.onboard.service.account.CompanyService;
import com.onboard.service.account.UserService;
import com.onboard.service.github.GithubInfoService;
import com.onboard.service.github.GithubService;
import com.onboard.service.github.utils.GitHubUtil;
import com.onboard.service.sampleProject.SampleProjectService;
import com.onboard.web.api.account.form.ThirdPartRegistrationForm;

@Controller
@RequestMapping("/signup")
public class ThirdPartSignupController {
    public static final Logger logger = LoggerFactory.getLogger(SignupController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private SampleProjectService sampleProjectService;

    @Autowired
    private GithubService githubService;

    @Autowired
    private GithubInfoService githubInfoService;

    @RequestMapping(value = "/github/callback", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> getGitHubResponse(HttpServletRequest request, @RequestParam("code") String code) {
        Map<String, String> signupMap = new HashMap<String, String>();
        User user = null;
        GithubInfo githubInfo = new GithubInfo();
        try {
            String token = GitHubUtil.getAccessToken(code);
            GithubUser githubUser = githubService.getGithubUserByOAuth(token);
            githubInfo.setUserId(Integer.valueOf(githubUser.getId()));
            List<GithubInfo> githubInfos = githubInfoService.getGithubInfosByExample(githubInfo, 0, -1);
            // 如果已经注册则直接进入
            if (githubInfos.size() != 0) {
                user = userService.getById(githubInfos.get(0).getOnboardUserId());
                signupMap.put("email", user.getEmail());
                signupMap.put("exist", String.valueOf(true));
                return signupMap;
            }
            githubInfo.setUserName(githubUser.getLogin());
            githubInfo.setUserEmail(githubUser.getEmail());
            githubInfo.setType("github");
            githubInfo.setCode(code);
            githubInfo.setToken(token);
            githubInfo.setDeleted(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

        githubInfoService.createGithubInfo(githubInfo);
        signupMap.put("thirdpartInfoId", String.valueOf(githubInfo.getId()));
        signupMap.put("exist", String.valueOf(false));
        signupMap.put("thirdpartEmail", githubInfo.getUserEmail());
        return signupMap;
    }

    @RequestMapping(value = "/github", method = RequestMethod.POST)
    @ResponseBody
    public boolean signUp(@RequestBody @Valid ThirdPartRegistrationForm form, @RequestParam("id") Integer id) {
        int thirdpartInfoId = id;
        // 创建用户，并且绑定到第三方登陆上
        form.setPassword(new Date().toString());
        User user = userService.signUp(form, form.getCompanyName());
        GithubInfo githubInfo = githubInfoService.getGithubInfoById(thirdpartInfoId);
        githubInfo.setOnboardUserId(user.getId());
        githubInfoService.updateByPrimaryKeySelective(githubInfo);
        int companyId = companyService.getCompaniesByUserId(user.getId()).get(0).getId();
        sampleProjectService.createSampleProjectByCompanyId(companyId, user);
        return true;
    }

}
