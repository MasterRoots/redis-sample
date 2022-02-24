package com.braga.redissample.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ExpireRequest {

    private String key;
    private long timeoutInSeconds;

}
