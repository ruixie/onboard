package com.onboard.web.api.form;

import org.hibernate.validator.constraints.Length;

import com.onboard.domain.model.Todo;

public class TodoForm extends Todo {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Length(min = 1, max = 200, message = "任务内容长度必须在1-50之间")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    boolean selective = true;

    public boolean isSelective() {
        return selective;
    }

    public void setSelective(boolean selective) {
        this.selective = selective;
    }

}
