package com.braga.redissample.gateway;

import com.braga.redissample.model.BitRequest;
import com.braga.redissample.usecases.BitOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("/redis")
public class BitOpsController {

    private final BitOperation operation;

    @PostMapping(path = "/bit", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Boolean setBit(@RequestBody final BitRequest request){
        return operation.setBit(request);
    }

    @GetMapping(path = "/bit", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Boolean getBit(@RequestBody final BitRequest request){
        return operation.getBit(request);
    }

    @GetMapping(path = "/bit-count/{key}")
    @ResponseStatus(HttpStatus.OK)
    public Long getCount(@PathVariable final String key){
        return operation.bitCount(key);
    }

    @PostMapping(path = "/bitop-and", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Long bitOpAnd(@RequestBody final BitRequest request){
        return operation.bitOp(RedisStringCommands.BitOperation.AND,request.getKeyDestination(),request.getKey(), request.getKey2());
    }

    @PostMapping(path = "/bitop-or", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Long bitOpOr(@RequestBody final BitRequest request){
        return operation.bitOp(RedisStringCommands.BitOperation.OR,request.getKeyDestination(),request.getKey(), request.getKey2());
    }



}
