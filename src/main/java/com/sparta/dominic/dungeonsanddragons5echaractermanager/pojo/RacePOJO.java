package com.sparta.dominic.dungeonsanddragons5echaractermanager.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class RacePOJO {

    @JsonProperty("trait_options")
    private TraitChoicePJO traitChoices;

    public TraitChoicePJO getTraitChoices() {
        return traitChoices;
    }
}
