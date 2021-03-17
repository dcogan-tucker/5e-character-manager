package com.sparta.dominic.dungeonsanddragons5echaractermanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
class ProficiencyChoicePOJO {

    @JsonProperty("choose")
    private int numberToChoose;
    @JsonProperty("from")
    private Collection<ProficiencyIndexPOJO> proficiencyOptions;

    public int getNumberToChoose() {
        return numberToChoose;
    }

    public Collection<ProficiencyIndexPOJO> getProficiencyOptions() {
        return proficiencyOptions;
    }
}