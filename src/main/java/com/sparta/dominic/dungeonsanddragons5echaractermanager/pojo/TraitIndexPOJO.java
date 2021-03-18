package com.sparta.dominic.dungeonsanddragons5echaractermanager.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TraitIndexPOJO {

    @JsonProperty("index")
    private String index;
    @JsonProperty("name")
    private String name;

    public String getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}
