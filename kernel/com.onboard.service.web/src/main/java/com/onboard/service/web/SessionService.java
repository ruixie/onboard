package com.onboard.service.web;

import com.onboard.domain.model.Company;
import com.onboard.domain.model.Project;
import com.onboard.domain.model.User;

/**
 * 用户Session信息。 包括当前公司、项目信息
 * 
 * @author Ruici
 * 
 */
public interface SessionService {

    public static final String CURRENT_USER = "currentUser";
    public static final String CURRENT_COMPANY = "currentCompany";
    public static final String CURRENT_PROJECT = "currentProject";
    public static final String TEMP_USER = "tempUser";

    public User getCurrentUser();

    public Company getCurrentCompany();

    public Project getCurrentProject();

    public void setCurrentUser(User user);

    public void setCurrentCompany(Company company);

    public void setCurrentProject(Project project);

    public void removeUserInformation();

    /**
     * set temp user while there are no http session
     */
    void setTempUser(User user);

}
