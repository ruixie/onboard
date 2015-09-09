package com.onboard.web.api.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onboard.domain.model.GithubInfo;
import com.onboard.domain.model.User;
import com.onboard.domain.transform.UserTransform;
import com.onboard.dto.UserDTO;
import com.onboard.service.account.UserService;
import com.onboard.service.github.GithubInfoService;
import com.onboard.service.security.exception.NoPermissionException;

@Controller
@RequestMapping("/")
public class SigninController {

    @Autowired
    private UserService userService;

    @Autowired
    private GithubInfoService githubInfoService;

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    @ResponseBody
    public UserDTO signIn(@RequestBody User user, @RequestParam(value = "thirdpartUserId",
            required = false,
            defaultValue = "-1") int thirdpartUserId) throws Exception {
        User currentUser = userService.login(user.getEmail(), user.getPassword());

        if (currentUser != null) {
            if (thirdpartUserId != -1) {
                GithubInfo githubInfo = githubInfoService.getGithubInfoById(thirdpartUserId);
                githubInfo.setOnboardUserId(currentUser.getId());

                githubInfoService.updateByPrimaryKeySelective(githubInfo);
            }
            return UserTransform.userToUserDTO(currentUser);
        } else {
            throw new NoPermissionException("用户名或密码错误");
        }
    }

}
