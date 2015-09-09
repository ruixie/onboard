package com.onboard.web.api.form;

import java.util.List;

public class InvitationForm {

    // TODO will cause exception if not initialize email address list
    public static final int MAX_MAIL_NO_PER_INVITATION = 100;

    private List<String> emailAddresses;

    private List<Integer> projectIdList;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(List<String> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    public List<Integer> getProjectIdList() {
        return projectIdList;
    }

    public void setProjectIdList(List<Integer> projectIdList) {
        this.projectIdList = projectIdList;
    }

}
