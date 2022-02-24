package com.braga.redissample.usecases;

import com.braga.redissample.model.BitRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BitOperation {
    private final RedisTemplate<String, String> redisTemplate;

    public Boolean setBit(final BitRequest request){
        return redisTemplate.opsForValue().setBit(request.getKey(),request.getOffset(),request.isValue());
    }

    public Boolean getBit(final BitRequest request){
        return redisTemplate.opsForValue().getBit(request.getKey(),request.getOffset());
    }

    public Long bitCount(final String key){
        return redisTemplate.execute((RedisCallback<Long>) con -> con.bitCount(key.getBytes()));
    }

    public Long bitOp(final RedisStringCommands.BitOperation op, final String keyDestination, final String key1, final String key2){
       return redisTemplate.execute((RedisCallback<Long>)
                con->con.bitOp(op,
                        keyDestination.getBytes(),
                        key1.getBytes(),
                        key2.getBytes()
                )
        );
    }
}
