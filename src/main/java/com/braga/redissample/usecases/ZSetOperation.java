package com.braga.redissample.usecases;


import com.braga.redissample.model.ZSetRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class ZSetOperation {

    private final RedisTemplate<String, String> redisTemplate;

    public Long sadd(final ZSetRequest request) {
        return redisTemplate.opsForSet().add(request.getKey(), request.getValue());
    }

    public Long scard(final String key) {
        return redisTemplate.opsForSet().size(key);
    }

    public Set<String> smembers(final String key){
        return redisTemplate.opsForSet().members(key);
    }

    public Boolean sIsMember(final ZSetRequest request){
        return redisTemplate.opsForSet().isMember(request.getKey(),request.getValue());
    }

    public Long srem(final ZSetRequest request){
        return redisTemplate.opsForSet().remove(request.getKey(),request.getValue());
    }

    public Set<String> sinter(final ZSetRequest request){
        return redisTemplate.opsForSet().intersect(request.getKey(),request.getKey2());
    }

    public Set<String> sdiff(final ZSetRequest request){
        return redisTemplate.opsForSet().difference(request.getKey(),request.getKey2());
    }

    public Set<String> sunion(final ZSetRequest request){
        return redisTemplate.opsForSet().union(request.getKey(),request.getKey2());
    }
}
