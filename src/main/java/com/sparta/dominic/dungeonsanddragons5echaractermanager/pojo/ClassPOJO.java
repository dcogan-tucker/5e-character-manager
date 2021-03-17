package com.sparta.dominic.dungeonsanddragons5echaractermanager.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClassPOJO {

    @JsonProperty("proficiency_choices")
    private ProficiencyChoicePOJO proficiencyChoices;

    public ProficiencyChoicePOJO getProficiencyChoices() {
        return proficiencyChoices;
    }
}
