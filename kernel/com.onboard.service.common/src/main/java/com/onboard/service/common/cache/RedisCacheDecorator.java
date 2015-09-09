package com.onboard.service.common.cache;

import java.util.Set;

import org.springframework.cache.Cache;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redis cache decorator for fluzzy evict.
 * 
 * @author XingLiang
 * 
 */

@SuppressWarnings("unchecked")
public class RedisCacheDecorator implements Cache {

    private Cache cache;

    private byte[] setName;

    private String name;

    @SuppressWarnings("rawtypes")
    private final RedisTemplate template;

    @SuppressWarnings("rawtypes")
    public RedisCacheDecorator(Cache cache, RedisTemplate template, String name) {
        this.cache = cache;
        this.template = template;
        this.name = name;
        StringRedisSerializer stringSerializer = new StringRedisSerializer();
        this.setName = stringSerializer.serialize(name + "~keys");
    }

    public Cache getCache() {
        return cache;
    }

    public void setCache(Cache cache) {
        this.cache = cache;
    }

    @SuppressWarnings("rawtypes")
    public RedisTemplate getTemplate() {
        return template;
    }

    public String getName() {
        return cache.getName();
    }

    public Object getNativeCache() {
        return cache.getNativeCache();
    }

    private String getKey(Object key) {
        return name + ":" + key;
    }

    public ValueWrapper get(final Object key) {
        return cache.get(getKey(key));
    }

    public void put(final Object key, final Object value) {
        cache.put(getKey(key), value);
    }

    public void evict(Object originKey) {
        String key = getKey(originKey);
        String keyString = "" + key;
        if (keyString.contains("*")) {
            String keyPattern = "*" + keyString;
            final byte[] k = template.getStringSerializer().serialize(keyPattern);
            template.execute(new RedisCallback<Object>() {
                public Object doInRedis(RedisConnection connection) {
                    Set<byte[]> keys = connection.keys(k);
                    for (byte[] currentKey : keys) {
                        connection.del(currentKey);
                        connection.zRem(setName, currentKey);
                    }
                    return null;
                }
            }, true);
        } else {
            cache.evict(key);
        }
    }

    public void clear() {
        cache.clear();
    }
}
