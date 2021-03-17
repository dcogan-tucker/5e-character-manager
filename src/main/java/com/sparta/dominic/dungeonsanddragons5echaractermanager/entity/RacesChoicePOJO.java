package com.sparta.dominic.dungeonsanddragons5echaractermanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RacesChoicePOJO {

    @JsonProperty("results")
    private Collection<RaceIndexPOJO> races;

    public Collection<RaceIndexPOJO> getClasses() {
        return races;
    }
}
