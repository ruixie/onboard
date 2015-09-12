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

import com.onboard.domain.mapper.model.CompanyExample;
import com.onboard.domain.model.Company;
import com.onboard.service.base.BaseService;

/**
 * {@link Company}相关服务
 * 
 * @author huangsz
 * 
 */
public interface CompanyService extends BaseService<Company, CompanyExample> {
    /**
     * 获取某个用户所在的所有团队的列表
     * @param userId 该用户的主键
     * @return 按要求从数据库中获取出的团队列表
     */
    List<Company> getCompaniesByUserId(int userId);

    /**
     * 在团队中移除某个用户
     * @param companyId 团队主键
     * @param userId 用户主键
     */
    void removeUser(Integer companyId, Integer userId);

    /**
     * 判断一个团队中是否包含某个用户
     * @param companyId 团队主键
     * @param userId 用户主键
     * @return 返回该判断是否为真
     */
    boolean containsUser(Integer companyId, Integer userId);

}
