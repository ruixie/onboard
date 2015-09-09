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
