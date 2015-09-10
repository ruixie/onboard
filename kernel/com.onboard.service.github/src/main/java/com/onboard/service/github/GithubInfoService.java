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
package com.onboard.service.github;

import java.util.List;

import com.onboard.domain.model.GithubInfo;

/**
 * {@link GithubInfo} Service Interface
 * 
 * @generated_by_elevenframework
 * 
 */
public interface GithubInfoService {
    /**
     * Get item by id
     * 
     * @param id
     * @return item
     */
    GithubInfo getGithubInfoById(int id);

    /**
     * Get item list
     * 
     * @param start
     * @param limit
     * @return the item list
     */
    List<GithubInfo> getGithubInfos(int start, int limit);

    /**
     * Get item list by example
     * 
     * @param item
     * @param start
     * @param limit
     * @return the item list
     */
    List<GithubInfo> getGithubInfosByExample(GithubInfo item, int start, int limit);

    /**
     * Get item count by example
     * 
     * @param item
     * @return the count
     */
    int countByExample(GithubInfo item);

    /**
     * Create
     * 
     * @param item
     * @return the created GithubInfo
     */
    GithubInfo createGithubInfo(GithubInfo item);

    /**
     * Update
     * 
     * @param item
     * @return the updated item
     */
    GithubInfo updateGithubInfo(GithubInfo item);

    /**
     * Delete
     * 
     * @param id
     */
    void deleteGithubInfo(int id);

    String getTokenByOnboardUserId(int onboardUserId);

    List<GithubInfo> getGithubInfoByUserId(int userId);

    void updateByPrimaryKeySelective(GithubInfo githubInfo);

    String getCodeByOnboardUserId(int onboardUserId);

    GithubInfo getGithubInfoByOnboardUserId(int onboardUserId);
}
