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
