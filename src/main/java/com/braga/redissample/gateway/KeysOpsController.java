package com.braga.redissample.gateway;

import com.braga.redissample.model.KeyRequest;
import com.braga.redissample.usecases.KeysOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/redis")
public class KeysOpsController {

    private final KeysOperation operation;

    @GetMapping(path = "/keys")
    @ResponseStatus(HttpStatus.OK)
    public Set<String> get(@RequestBody final KeyRequest request){
        return operation.keys(request.getPattern());
    }
}
