package com.github.wangyuheng.utmanual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    @Autowired
    private RedisTemplate redisTemplate;

    public void put(String key, Object value) {
        redisTemplate.boundHashOps("cache:common").put(key, value);
    }

    public Object get(String key) {
        return redisTemplate.boundHashOps("cache:common").get(key);
    }

}