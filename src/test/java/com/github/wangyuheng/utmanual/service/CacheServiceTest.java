package com.github.wangyuheng.utmanual.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.embedded.RedisServer;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheServiceTest {

    @Autowired
    private CacheService cacheService;
    private RedisServer redisServer = new RedisServer(6378);
    @Before
    public void setUp(){
        redisServer.start();
    }

    @After
    public void tearDown(){
        redisServer.stop();
    }

    @Test
    public void test_redis_set_get() {
        cacheService.put("a","b");
        assertEquals("b",cacheService.get("a"));
    }

}