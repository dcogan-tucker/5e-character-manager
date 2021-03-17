package com.sparta.dominic.dungeonsanddragons5echaractermanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TraitChoicePJO {

    @JsonProperty("choose")
    private int numberToChoose;
    @JsonProperty("from")
    private Collection<TraitIndex> traits;

    public int getNumberToChoose() {
        return numberToChoose;
    }

    public Collection<TraitIndex> getTraits() {
        return traits;
    }
}
