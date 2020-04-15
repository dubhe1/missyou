package com.missyou.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Spec implements Serializable {

    @JsonProperty("key_id")
    private Long keyId;
    private String key;
    @JsonProperty("value_id")
    private Long valueId;
    private String value;
}


