package com.braga.redissample.usecases;

import com.braga.redissample.model.ExpireRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Service
public class ExpireOperation {
    private final RedisTemplate<String, String> redisTemplate;

    public Boolean expire(final ExpireRequest request){
            return redisTemplate.expire(request.getKey(), request.getTimeoutInSeconds(), TimeUnit.SECONDS );
    }

    public long ttl(final String key){
         return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }



}
