package com.onboard.service.github.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Component
public class GitHubUtil {

    private static String CLIENT_ID;

    private static String CLIENT_SECRET;

    @Value("${data.github.client_id}")
    void setClientId(String client_id) {
        CLIENT_ID = client_id;
    }

    @Value("${data.github.client_secret}")
    void setClientSecret(String clientSecret) {
        CLIENT_SECRET = clientSecret;
    }

    // private static final String GITHUB_OAUTH_TOKEN = "https://github.com/login/oauth/access_token";
    private static final String GITHUB_OAUTH_TOKEN = "https://github.com/login/oauth/access_token?client_id=%s&client_secret=%s&code=%s";

    public static String getAccessToken(String code) throws Exception {
        Client client = Client.create();
        // WebResource webResource = client.resource(GITHUB_OAUTH_TOKEN);
        WebResource webResource = client.resource(String.format(GITHUB_OAUTH_TOKEN, CLIENT_ID, CLIENT_SECRET, code));
        // ClientResponse response = webResource.accept("application/json").post(ClientResponse.class).getEntity(String.class);
        String responseString = webResource.accept("application/json").post(ClientResponse.class).getEntity(String.class);

        String gitHubToken = responseString.split(",")[0].split(":")[1].split("\"")[1];

        return gitHubToken;
    }

}
