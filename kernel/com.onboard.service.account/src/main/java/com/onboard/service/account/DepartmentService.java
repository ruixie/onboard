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
     * 将一个用户移动到特定分组下
     * @param userCompany 新的用户-分组对象
     */
    void updateDepartmentOfUser(UserCompany userCompany);

    /**
     * 对于传入的分组列表，对其按照主键从小到大排序
     * @param ids
     */
    void sortDepartment(List<Integer> groupIds);

    /**
     * 获取一个用户在特定团队中的分组
     * @param companyId 团队主键
     * @param userId 用户主键
     * @return 按要求从数据库中获取出的分组对象
     */
    Department getDepartmentByCompanyIdByUserId(int companyId, int userId);

    /**
     * 获取一个用户在特定团队中的分组，并将分组对象填充进用户对象中
     * @param user 用户对象
     * @param companyId 团队主键
     */
    void fillUserDepartmentInCompany(User user, int companyId);

    /**
     * 对于一个用户列表，获取其中每一个用户在特定团队中的分组，并将分组对象填充进用户对象中
     * @param users 用户列表
     * @param companyId 团队主键
     */
    void fillUsersDepartmentInCompany(List<User> users, int companyId);

}
