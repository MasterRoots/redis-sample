package com.braga.redissample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class BitRequest {

    private String key;
    private long offset;
    private boolean value;
    private String keyDestination;
    private String key2;


}
