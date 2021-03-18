package com.sparta.dominic.dungeonsanddragons5echaractermanager.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClassPOJO {

    @JsonProperty("proficiency_choices")
    private Collection<ProficiencyChoicePOJO> proficiencyChoices;

    public Collection<ProficiencyChoicePOJO> getProficiencyChoices() {
        return proficiencyChoices;
    }
}
