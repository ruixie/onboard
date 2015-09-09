package com.onboard.service.wiki.utils;

public class KeyUtils {

    public static String documentLockKey(int documentId) {
        return String.format("lock:document:%d", documentId);
    }
}
