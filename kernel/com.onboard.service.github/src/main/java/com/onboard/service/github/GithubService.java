package com.onboard.service.github;

import java.util.List;

import com.onboard.domain.model.GitHubRepository;
import com.onboard.domain.model.GithubBranch;
import com.onboard.domain.model.GithubUser;

public interface GithubService {
    public List<GitHubRepository> getPublicRepository(String login) throws Exception;

    public List<GithubBranch> getBranchesOfGithubRepository(String githubRepositoryName) throws Exception;

    public List<GitHubRepository> getGitHubRepositoriesByOAuth(String token) throws Exception;

    public GithubUser getGithubUserByOAuth(String token) throws Exception;

}
