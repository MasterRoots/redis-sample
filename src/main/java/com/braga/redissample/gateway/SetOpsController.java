package com.braga.redissample.gateway;

import com.braga.redissample.model.SetRequest;
import com.braga.redissample.usecases.SetOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("/redis")
public class SetOpsController {

    private final SetOperation setOperation;

    @PostMapping(path = "/set", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void set(@RequestBody final SetRequest setRequest){
         setOperation.set(setRequest.getKey(),setRequest.getValue());
    }

    @GetMapping(path = "/set/{key}")
    @ResponseStatus(HttpStatus.OK)
    public String get(@PathVariable final String key){
        return setOperation.get(key);
    }

    @DeleteMapping(path = "/set/{key}")
    @ResponseStatus(HttpStatus.OK)
    public void del(@PathVariable final String key){
         setOperation.del(key);
    }

}
