package com.sparta.dominic.dungeonsanddragons5echaractermanager.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProficiencyChoicePOJO {

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