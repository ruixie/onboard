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
package com.onboard.service.account;

import java.util.List;

import com.onboard.domain.mapper.model.DepartmentExample;
import com.onboard.domain.model.Department;
import com.onboard.domain.model.User;
import com.onboard.domain.model.UserCompany;
import com.onboard.service.base.BaseService;

/**
 * @author xuchen
 */
public interface DepartmentService extends BaseService<Department, DepartmentExample> {

    /**
     * 更新用户所在的组
     * 
     * @param userCompany
     */
    void updateDepartmentOfUser(UserCompany userCompany);

    /**
     * 对分组进行排序
     * 
     * @param ids
     */
    void sortDepartment(List<Integer> groupIds);

    /**
     * @param userId
     * @return
     */
    Department getDepartmentByCompanyIdByUserId(int companyId, int userId);

    /**
     * 找到用户在某公司的departmentId，并填充
     */
    void fillUserDepartmentInCompany(User user, int companyId);

    /**
     * 填充某公司一组用户的departmentId
     */
    void fillUsersDepartmentInCompany(List<User> users, int companyId);

}
