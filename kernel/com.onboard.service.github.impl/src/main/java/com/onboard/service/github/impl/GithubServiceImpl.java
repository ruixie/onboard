package com.onboard.service.github.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.onboard.domain.model.GitHubRepository;
import com.onboard.domain.model.GithubBranch;
import com.onboard.domain.model.GithubUser;
import com.onboard.service.github.GithubService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Service("githubServiceBean")
public class GithubServiceImpl implements GithubService {
    private static final String GITHUBURL = "https://api.github.com/users/%s/repos";
    private static final String BRANCHESURL = "https://api.github.com/repos/%s/branches";
    private static final String GITHUBREPOSBYOAUTHURL = "https://api.github.com/user/repos?access_token=%s";
    private static final String GITHUBUSERBYOAUTHURL = "https://api.github.com/user?access_token=%s";

    public static final Logger logger = LoggerFactory.getLogger(GithubServiceImpl.class);

    @Override
    public List<GitHubRepository> getPublicRepository(String login) throws Exception {
        List<GitHubRepository> gitHubRepositories = new ArrayList<GitHubRepository>();
        Client client = Client.create();
        WebResource webResource = client.resource(String.format(GITHUBURL, login));
        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

        if (response.getStatus() != 200) {
            logger.info(" GithubServiceImpl get Repository failured!");
            throw new Exception("get Repository failured!");
        }
        String responseString = response.getEntity(String.class);
        GitHubRepository[] data = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            data = mapper.readValue(responseString, GitHubRepository[].class);
            gitHubRepositories = Arrays.asList(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gitHubRepositories;
    }

    @Override
    public List<GithubBranch> getBranchesOfGithubRepository(String githubRepositoryName) throws Exception {
        List<GithubBranch> githubBranches = new ArrayList<GithubBranch>();
        Client client = Client.create();
        WebResource webResource = client.resource(String.format(BRANCHESURL, githubRepositoryName));
        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
        GithubBranch[] branches = null;
        if (response.getStatus() != 200) {
            logger.info("GithubServiceImpl get branches failured!");
            throw new Exception("get branches failured!");
        }
        String branchString = response.getEntity(String.class);
        ObjectMapper branchMapper = new ObjectMapper();
        branchMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            branchMapper.readValue(branchString, GithubBranch[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        githubBranches = Arrays.asList(branches);

        return githubBranches;
    }

    @Override
    public List<GitHubRepository> getGitHubRepositoriesByOAuth(String token) throws Exception {
        List<GitHubRepository> gitHubRepositories = new ArrayList<GitHubRepository>();
        Client client = Client.create();
        WebResource webResource = client.resource(String.format(GITHUBREPOSBYOAUTHURL, token));
        // ClientResponse response = webResource.queryParam("access_token", token).accept("application/json")
        // .get(ClientResponse.class);
        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

        if (response.getStatus() != 200) {
            logger.info(" GithubServiceImpl get Repository failured!");
            throw new Exception("get Repository failured!");
        }
        String responseString = response.getEntity(String.class);
        GitHubRepository[] data = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            data = mapper.readValue(responseString, GitHubRepository[].class);
            gitHubRepositories = Arrays.asList(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gitHubRepositories;
    }

    @Override
    public GithubUser getGithubUserByOAuth(String token) throws Exception {
        GithubUser githubUser = new GithubUser();
        Client client = Client.create();
        WebResource webResource = client.resource(String.format(GITHUBUSERBYOAUTHURL, token));
        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
        String responseString = response.getEntity(String.class);
        if (response.getStatus() != 200) {
            logger.info(" GithubServiceImpl get User Info failured!");
            throw new Exception("get GithubUser Info failured!");
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            githubUser = mapper.readValue(responseString, GithubUser.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return githubUser;
    }

}
