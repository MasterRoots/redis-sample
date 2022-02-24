package com.braga.redissample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class MultiHash {

    private String type;
    private Map<String,String> map;
    private Collection<Object> fields;

}
