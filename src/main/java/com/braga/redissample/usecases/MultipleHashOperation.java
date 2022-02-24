package com.braga.redissample.usecases;

import com.braga.redissample.model.MultiHash;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MultipleHashOperation {

    private final RedisTemplate<String, String> redisTemplate;

    public void hmset(final MultiHash hash){
        redisTemplate.opsForHash().putAll(hash.getType(),hash.getMap());
    }

    public List<Object> hmget(final MultiHash hash){
        return redisTemplate.opsForHash().multiGet(hash.getType(), hash.getFields());
    }
}
