package com.braga.redissample.usecases;

import com.braga.redissample.model.ListRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListOperation {

    private final RedisTemplate<String, String> redisTemplate;

    public Long lpush(final ListRequest request){
        return redisTemplate.opsForList().leftPush(request.getKey(), request.getValue());
    }

    public Long rpush(final ListRequest request){
        return redisTemplate.opsForList().rightPush(request.getKey(), request.getValue());
    }

    public String lindex(final  ListRequest request){
        return redisTemplate.opsForList().index(request.getKey(), request.getIndex());
    }

    public List<String> lrange(final ListRequest request){
        return redisTemplate.opsForList().range(request.getKey(), request.getIndexStart(), request.getIndexEnd());
    }

    public void ltrim(final ListRequest request){
        redisTemplate.opsForList().trim(request.getKey(),request.getIndexStart(), request.getIndexEnd());
    }

    public Long llen(final String key){
       return redisTemplate.opsForList().size(key);
    }

    public String lpop(final String key){
        return redisTemplate.opsForList().leftPop(key);
    }

    public String rpop(final String key){
        return  redisTemplate.opsForList().rightPop(key);
    }
}
