package com.onboard.web.api.account.form;

import com.onboard.web.api.constraints.EmailExists;

public class ForgetPasswordForm {

    @EmailExists(exist = true, message = "邮箱地址不存在")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
