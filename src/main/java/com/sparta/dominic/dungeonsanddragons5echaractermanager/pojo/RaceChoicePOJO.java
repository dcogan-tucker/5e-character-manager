package com.sparta.dominic.dungeonsanddragons5echaractermanager.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RaceChoicePOJO {

    @JsonProperty("results")
    private Collection<RaceIndexPOJO> races;

    public Collection<RaceIndexPOJO> getClasses() {
        return races;
    }
}
