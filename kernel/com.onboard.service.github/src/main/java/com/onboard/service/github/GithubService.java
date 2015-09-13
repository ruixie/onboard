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

import com.onboard.domain.model.GitHubRepository;
import com.onboard.domain.model.GithubBranch;
import com.onboard.domain.model.GithubUser;

public interface GithubService {
	
	/**
	 * Get public repositories by one's login url
	 * 
	 * @param login the login url of a user
	 * @return a list of public repositories
	 * @throws Exception
	 */
    public List<GitHubRepository> getPublicRepository(String login) throws Exception;

    /**
     * Get all branches by a repository's name
     * 
     * @param githubRepositoryName the repository's name
     * @return a list of branches
     * @throws Exception
     */
    public List<GithubBranch> getBranchesOfGithubRepository(String githubRepositoryName) throws Exception;

    /**
     * Get all repositories by one's token
     * 
     * @param token the token of a user
     * @return a list of all repositories
     * @throws Exception
     */
    public List<GitHubRepository> getGitHubRepositoriesByOAuth(String token) throws Exception;

    /**
     * Get a user object by one's token
     * 
     * @param token the token of a user
     * @return a object of the user
     * @throws Exception
     */
    public GithubUser getGithubUserByOAuth(String token) throws Exception;

}
