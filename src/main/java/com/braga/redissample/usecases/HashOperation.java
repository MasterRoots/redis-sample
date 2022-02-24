package com.braga.redissample.usecases;

import com.braga.redissample.model.Hash;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HashOperation {

    private final RedisTemplate<String, String> redisTemplate;

    public void hset(final Hash hash){
        redisTemplate.opsForHash().put(hash.getType(),hash.getId(),hash.getName());
    }

    public String hget(final Hash hash ) {
        return  (String) redisTemplate.opsForHash().get(hash.getType(), hash.getId());

    }

    public Map<String, String> hgetAll(final String type){

        final Map<Object, Object> entries = redisTemplate.opsForHash().entries(type);

        return entries
                .entrySet()
                .stream()
                .collect(Collectors
                    .toMap(
                            e -> (String) e.getKey(),
                            e-> (String) e.getValue()));

    }

    public void delete(final Hash hash){
        redisTemplate.opsForHash().delete(hash.getType(),hash.getId());
    }
}
