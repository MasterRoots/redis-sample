package com.braga.redissample.gateway;

import com.braga.redissample.model.ExpireRequest;
import com.braga.redissample.model.Hash;
import com.braga.redissample.usecases.ExpireOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("/redis")
public class ExpireOpsController {

    private final ExpireOperation operation;

    @PostMapping(path = "/expire", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Boolean set(@RequestBody final ExpireRequest request){
        return operation.expire(request);
    }

    @GetMapping(path = "/ttl/{key}")
    @ResponseStatus(HttpStatus.OK)
    public long ttl(@PathVariable final String key){
        return operation.ttl(key);
    }
}
