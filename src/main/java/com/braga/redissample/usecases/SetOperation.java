package com.braga.redissample.usecases;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SetOperation {

    private final RedisTemplate<String, String> redisTemplate;

    public void set(final String key, final String value){
        redisTemplate.opsForValue().set(key,value);
    }

    public String get(final String key){
        return redisTemplate.opsForValue().get(key);
    }

    public void del(final String key){
        redisTemplate.opsForValue().getAndDelete(key);
    }




}
