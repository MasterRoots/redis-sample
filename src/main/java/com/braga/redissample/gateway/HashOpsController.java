package com.braga.redissample.gateway;

import com.braga.redissample.model.Hash;
import com.braga.redissample.usecases.HashOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("/redis")
public class HashOpsController {

    private final HashOperation operation;

    @PostMapping(path = "/hash", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void set(@RequestBody final Hash request){
        operation.hset(request);
    }

    @GetMapping(path = "/hash", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String get(@RequestBody final Hash request){
        return operation.hget(request);
    }

    @GetMapping(path = "/hash/all/{key}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String,String> getAll(@PathVariable final String key){
        return operation.hgetAll(key);
    }

    @DeleteMapping(path = "/hash", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestBody final Hash request){
        operation.delete(request);
    }


}
