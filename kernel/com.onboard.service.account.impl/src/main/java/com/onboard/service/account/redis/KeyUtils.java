package com.onboard.service.account.redis;

import com.google.common.base.Preconditions;

public class KeyUtils {

    public static String userToken(String type, Integer uid) {
        Preconditions.checkNotNull(type);
        Preconditions.checkNotNull(uid);
        return String.format("account:%s:%d", type, uid);
    }

}
