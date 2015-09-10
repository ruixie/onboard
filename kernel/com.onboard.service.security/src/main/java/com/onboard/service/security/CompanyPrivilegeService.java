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
package com.onboard.service.security;

import java.util.List;

import com.onboard.domain.model.CompanyPrivilege;

/**
 * {@link CompanyPrivilege} Service Interface
 * 
 * @author XR
 * 
 */
public interface CompanyPrivilegeService {
    /**
     * Get item by id
     * 
     * @param id
     * @return item
     */
    CompanyPrivilege getCompanyPrivilegeById(int id);

    /**
     * Get item list
     * 
     * @param start
     * @param limit
     * @return the item list
     */
    List<CompanyPrivilege> getCompanyPrivileges(int start, int limit);

    /**
     * Update
     * 
     * @param item
     * @return the updated item
     */
    CompanyPrivilege setCompanyPrivilege(CompanyPrivilege item);

    /**
     * Get item list by example
     * 
     * @param item
     * @param start
     * @param limit
     * @return the item list
     */
    List<CompanyPrivilege> getCompanyPrivilegesByExample(CompanyPrivilege item, int start, int limit);

    /**
     * Get item count by example
     * 
     * @param item
     * @return the count
     */
    int countByExample(CompanyPrivilege item);

    /**
     * Create
     * 
     * @param item
     * @return the created CompanyPrivilege
     */
    CompanyPrivilege createCompanyPrivilege(CompanyPrivilege item);

    /**
     * Update
     * 
     * @param item
     * @return the updated item
     */
    CompanyPrivilege updateCompanyPrivilege(CompanyPrivilege item);

    /**
     * Delete
     * 
     * @param id
     */
    void deleteCompanyPrivilege(int id);

    /**
     * 获取用户在公司的权限，如果权限尚不存在，则创建一个
     * 
     * @param companyId
     * @param userId
     * @return
     */
    CompanyPrivilege getOrCreateCompanyPrivilegeByUserId(int companyId, int userId);
}
