package com.braga.redissample.gateway;

import com.braga.redissample.model.ListRequest;
import com.braga.redissample.usecases.ListOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("/redis/")
public class ListOpsController {

    private final ListOperation operation;

    @PostMapping(path = "/lpush", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Long lpush(@RequestBody final ListRequest request){
        return operation.lpush(request);
    }

    @PostMapping(path = "/rpush", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Long rpush(@RequestBody final ListRequest request){
        return operation.rpush(request);
    }

    @GetMapping(path = "/lindex", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String lindex(@RequestBody final ListRequest request){
        return operation.lindex(request);
    }

    @GetMapping(path = "/lrange", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<String> lrange(@RequestBody final ListRequest request){
        return operation.lrange(request);
    }

    @PostMapping(path = "/ltrim", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void ltrim(@RequestBody final ListRequest request){
        operation.ltrim(request);
    }

    @GetMapping(path = "/llen/{key}")
    @ResponseStatus(HttpStatus.OK)
    public Long llen(@PathVariable final String key){
        return operation.llen(key);
    }

    @GetMapping(path = "/lpop/{key}")
    @ResponseStatus(HttpStatus.OK)
    public String lpop(@PathVariable final String key){
        return operation.lpop(key);
    }

    @GetMapping(path = "/rpop/{key}")
    @ResponseStatus(HttpStatus.OK)
    public String rpop(@PathVariable final String key){
        return operation.rpop(key);
    }

    @PostMapping(path = "/blpop",consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<byte[]> blpop(@RequestBody final ListRequest request){
        return operation.blpop(request);
    }

    @PostMapping(path = "/brpop",consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<byte[]> brpop(@RequestBody final ListRequest request){
        return operation.brpop(request);
    }



}
