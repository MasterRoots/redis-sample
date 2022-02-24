package com.braga.redissample.gateway;

import com.braga.redissample.model.MultiHash;
import com.braga.redissample.model.MultiSetRequest;
import com.braga.redissample.usecases.MultipleHashOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("/redis/")
public class MultipleHashOpsController{

    private final MultipleHashOperation operation;

    @PostMapping(path = "/multihash", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void set(@RequestBody final MultiHash request){
        operation.hmset(request);
    }

    @GetMapping(path = "/multihash", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Object> get(@RequestBody final MultiHash request){
        return operation.hmget(request);
    }
}
