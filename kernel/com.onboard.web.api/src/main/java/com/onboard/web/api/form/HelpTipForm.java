package com.onboard.web.api.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.onboard.domain.model.HelpTip;

public class HelpTipForm extends HelpTip {
    @Length(min = 1, max = 100, message = "标题长度必须在1-100之间")
    @NotNull
    @NotBlank
    private String title;

    @NotNull
    @NotBlank
    private String question;

    @NotNull
    @NotBlank
    private String answer;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
