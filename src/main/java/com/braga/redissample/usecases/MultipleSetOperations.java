package com.braga.redissample.usecases;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MultipleSetOperations {

    private final RedisTemplate<String, String> redisTemplate;

    public void multipleSet(final Map<String, String> multi){
        redisTemplate.opsForValue().multiSet(multi);
    }

    public List<String> multipleGet(final List<String> keys){
        return redisTemplate.opsForValue().multiGet(keys);
    }
}
