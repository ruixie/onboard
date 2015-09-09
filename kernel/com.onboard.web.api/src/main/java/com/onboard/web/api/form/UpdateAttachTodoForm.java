package com.onboard.web.api.form;

import java.util.List;

import com.onboard.domain.model.AttachTodo;

public class UpdateAttachTodoForm {
    List<AttachTodo> add;
    List<AttachTodo> remove;
    public List<AttachTodo> getAdd() {
        return add;
    }
    public void setAdd(List<AttachTodo> add) {
        this.add = add;
    }
    public List<AttachTodo> getRemove() {
        return remove;
    }
    public void setRemove(List<AttachTodo> remove) {
        this.remove = remove;
    }

}
