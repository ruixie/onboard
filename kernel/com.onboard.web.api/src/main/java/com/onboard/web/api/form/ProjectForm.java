package com.onboard.web.api.form;

import java.util.List;

import com.onboard.domain.model.Project;
import com.onboard.domain.model.User;

public class ProjectForm extends Project {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private List<User> admins;

    @Override
    public List<User> getAdmins() {
        return admins;
    }

    @Override
    public void setAdmins(List<User> admins) {
        this.admins = admins;
    }
}
