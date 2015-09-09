package com.onboard.service.account.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AccountConfigure {

    private String protocol = "https://";

    @Value("${account.tokenExpired}")
    private int tokenExpired;

    @Value("${account.rememberMeExpired}")
    private int rememberMeExpired;

    @Value("${site.host}")
    private String host;

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public int getTokenExpired() {
        return tokenExpired;
    }

    public void setTokenExpired(int tokenExpired) {
        this.tokenExpired = tokenExpired;
    }

    public int getRememberMeExpired() {
        return rememberMeExpired;
    }

    public void setRememberMeExpired(int rememberMeExpired) {
        this.rememberMeExpired = rememberMeExpired;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

}
