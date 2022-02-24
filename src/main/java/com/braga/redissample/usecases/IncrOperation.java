package com.braga.redissample.usecases;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IncrOperation {

    private final RedisTemplate<String, String> redisTemplate;


    public Long incr(final String key){
        return redisTemplate.opsForValue().increment(key);
    }

    public Long incrBy(final String key, final long value){
        return redisTemplate.opsForValue().increment(key, value);
    }

    public Long decr(final String key){
        return redisTemplate.opsForValue().decrement(key);
    }

    public Long decrBy(final String key, final long value){
        return redisTemplate.opsForValue().decrement(key,value);
    }

    public Double incrByFloat(final String key, final double value){
        return redisTemplate.opsForValue().increment(key,value);
    }

}
