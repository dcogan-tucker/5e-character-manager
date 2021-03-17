package com.sparta.dominic.dungeonsanddragons5echaractermanager.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TraitChoicePJO {

    @JsonProperty("choose")
    private int numberToChoose;
    @JsonProperty("from")
    private Collection<TraitIndexPOJO> traits;

    public int getNumberToChoose() {
        return numberToChoose;
    }

    public Collection<TraitIndexPOJO> getTraits() {
        return traits;
    }
}
