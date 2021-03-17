package com.sparta.dominic.dungeonsanddragons5echaractermanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TraitIndex {

    @JsonProperty("index")
    private String index;

    public String getIndex() {
        return index;
    }
}
