package com.braga.redissample.gateway;

import com.braga.redissample.model.SetRequest;
import com.braga.redissample.model.ZSetRequest;
import com.braga.redissample.usecases.ZSetOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("/redis")
public class ZSetOpsController {

    private final ZSetOperation operation;

    @PostMapping(path = "/sadd", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Long sadd(@RequestBody final ZSetRequest request){
        return operation.sadd(request);
    }

    @GetMapping(path = "/scard/{key}")
    @ResponseStatus(HttpStatus.OK)
    public Long scard(@PathVariable final String key){
        return operation.scard(key);
    }

    @GetMapping(path = "/smembers/{key}")
    @ResponseStatus(HttpStatus.OK)
    public Set<String> smembers(@PathVariable final String key){
       return operation.smembers(key);
    }

    @PostMapping(path = "/sismember", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Boolean sismember(@RequestBody final ZSetRequest request){
        return operation.sIsMember(request);
    }

    @DeleteMapping(path = "/srem", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Long srem(@RequestBody final ZSetRequest request){
        return operation.srem(request);
    }

    @PostMapping(path = "/sinter", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Set<String> sinter(@RequestBody final ZSetRequest request){
        return operation.sinter(request);
    }

    @PostMapping(path = "/sdiff", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Set<String> sdiff(@RequestBody final ZSetRequest request){
        return operation.sdiff(request);
    }

    @PostMapping(path = "/sunion", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Set<String> sunion(@RequestBody final ZSetRequest request){
        return operation.sunion(request);
    }

}
