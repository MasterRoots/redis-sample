package com.braga.redissample.usecases;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class KeysOperation {

    private final RedisTemplate<String, String> redisTemplate;

    public Set<String> keys(final String pattern){
        return redisTemplate.keys(pattern);
    }
}
