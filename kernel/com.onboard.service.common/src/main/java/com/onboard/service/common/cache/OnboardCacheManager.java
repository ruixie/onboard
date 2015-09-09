package com.onboard.service.common.cache;

import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * custom cacheManager for fluzzy cache evict
 * 
 * @author XingLiang
 * 
 */
public class OnboardCacheManager extends RedisCacheManager {

    @SuppressWarnings("rawtypes")
    private RedisTemplate template;

    public OnboardCacheManager(@SuppressWarnings("rawtypes") RedisTemplate template) {
        super(template);
        this.template = template;
    }

    @Override
    public Cache getCache(String name) {
        Cache redisCache = super.getCache(name);

        return new RedisCacheDecorator(redisCache, template, name);
    }
}
