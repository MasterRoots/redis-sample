package com.braga.redissample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ListRequest {

    private String key;
    private String value;
    private long index;
    private long indexStart;
    private long indexEnd;
    private int timeout;
}
