package com.sparta.dominic.dungeonsanddragons5echaractermanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClassChoicePOJO {

    @JsonProperty("results")
    private Collection<ClassIndexPOJO> classes;

    public Collection<ClassIndexPOJO> getClasses() {
        return classes;
    }
}
