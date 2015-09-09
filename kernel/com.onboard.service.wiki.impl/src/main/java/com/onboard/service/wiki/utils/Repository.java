package com.onboard.service.wiki.utils;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component("documentRepository")
public class Repository {

    @Autowired
    private StringRedisTemplate template;

    private ValueOperations<String, String> valueOps;

    @PostConstruct
    public void init() {
        valueOps = template.opsForValue();
    }

    public int getUidOfLocker(int documentId) {
        String value = valueOps.get(KeyUtils.documentLockKey(documentId));
        if (value == null) {
            return 0;
        }

        return Integer.parseInt(value);
    }

    public void lockDocument(int documentId, int userId, int timeout) {
        valueOps.set(KeyUtils.documentLockKey(documentId), String.valueOf(userId), timeout, TimeUnit.SECONDS);
    }

    public void updateLockerOfDocument(int documentId, int timeout) {
        template.expire(KeyUtils.documentLockKey(documentId), timeout, TimeUnit.SECONDS);
    }

    public void unlockDocument(int documentId) {
        template.delete(KeyUtils.documentLockKey(documentId));
    }
}
