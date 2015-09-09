package com.onboard.web.api.form;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

import com.onboard.domain.model.AttachTodo;

public class AttachTodoForm extends AttachTodo {

    @NotBlank
    private String attachType;

    @Min(1)
    private Integer attachId;

    @Min(1)
    private Integer todoId;

    public String getAttachType() {
        return attachType;
    }

    public void setAttachType(String attachType) {
        this.attachType = attachType;
    }

    public Integer getAttachId() {
        return attachId;
    }

    public void setAttachId(Integer attachId) {
        this.attachId = attachId;
    }

    public Integer getTodoId() {
        return todoId;
    }

    public void setTodoId(Integer todoId) {
        this.todoId = todoId;
    }

}
