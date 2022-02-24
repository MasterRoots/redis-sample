package com.braga.redissample.gateway;

import com.braga.redissample.model.MultiSetRequest;
import com.braga.redissample.usecases.MultipleSetOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("/redis/")
public class MutipleSetOpsController {

    private final MultipleSetOperation operations;

    @PostMapping(path = "/multiset", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void set(@RequestBody final MultiSetRequest  request){
        operations.multipleSet(request.getMap());
    }

    @GetMapping(path = "/multiget", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<String> get(@RequestBody final MultiSetRequest  request){
        return operations.multipleGet(request.getKeys());
    }
}
