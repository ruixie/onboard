package com.onboard.web.api.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class UpdateHelpTipForm {
    @Length(min = 1, max = 100, message = "标题长度必须在1-100之间")
    @NotNull
    private String title;
    @Length(min = 1, max = 100, message = "标题长度必须在1-100之间")
    @NotNull
    private String newTitle;

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
