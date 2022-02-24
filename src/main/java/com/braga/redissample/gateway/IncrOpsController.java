package com.braga.redissample.gateway;

import com.braga.redissample.model.Hash;
import com.braga.redissample.model.IncrRequest;
import com.braga.redissample.usecases.IncrOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("/redis")
public class IncrOpsController {

    private final IncrOperation operation;

    @PostMapping(path = "/incr/{key}")
    @ResponseStatus(HttpStatus.OK)
    public Long incr(@PathVariable final String key){
        return operation.incr(key);
    }

    @PostMapping(path = "/incr-by", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Long incrBy(@RequestBody final IncrRequest request){
        return operation.incrBy(request.getKey(), request.getLongValue());
    }

    @PostMapping(path = "/decr/{key}")
    @ResponseStatus(HttpStatus.OK)
    public Long decr(@PathVariable final String key){
        return operation.decr(key);
    }

    @PostMapping(path = "/decr-by", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Long decrBy(@RequestBody final IncrRequest request){
        return operation.decrBy(request.getKey(),request.getLongValue());
    }

    @PostMapping(path = "/incr-by-float", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Double incrByFloat(@RequestBody final IncrRequest request){
        return operation.incrByFloat(request.getKey(),request.getDoubleValue());
    }


}
