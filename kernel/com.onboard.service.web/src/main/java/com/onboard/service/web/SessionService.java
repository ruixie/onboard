/*******************************************************************************
 * Copyright [2015] [Onboard team of SERC, Peking University]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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
