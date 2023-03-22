package com.test.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CounterController {
    private int i = 0;  // mysql,redis

    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping("/hello")
    public String Count(){
        Long increment = redisTemplate.opsForValue().increment("count-people");
        return "有["+ increment +"]个人访问我的页面";
    }
}
