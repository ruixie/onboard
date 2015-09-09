package com.onboard.service.account.redis;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component("luozongshuai")
public class Repository {

    public static final Logger logger = LoggerFactory.getLogger(Repository.class);

    @Autowired
    private StringRedisTemplate template;

    private ValueOperations<String, String> valueOps;

    @PostConstruct
    public void init() {
        valueOps = template.opsForValue();
    }

    public String addToken(TokenType type, int uid, int timeout) {
        String token = UUID.randomUUID().toString();
        valueOps.set(KeyUtils.userToken(type.getName(), uid), token, timeout, TimeUnit.SECONDS);
        return token;
    }

    public boolean authenticateToken(TokenType type, int uid, String token) {
        String value = valueOps.get(KeyUtils.userToken(type.getName(), uid));
        return value != null && value.equals(token);
    }

    public void delToken(TokenType type, int uid) {
        template.delete(KeyUtils.userToken(type.getName(), uid));
    }

}
