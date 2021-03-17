package com.sparta.dominic.dungeonsanddragons5echaractermanager.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.dominic.dungeonsanddragons5echaractermanager.pojo.*;
import com.sparta.dominic.dungeonsanddragons5echaractermanager.utill.DnD5eAPI;

import java.io.IOException;
import java.net.URL;

public class APIQueryService {

    private ObjectMapper objectMapper;

    public APIQueryService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public RaceChoicePOJO getRaceChoices() {
        RaceChoicePOJO raceChoice;
        try {
            raceChoice = objectMapper.readValue(new URL(DnD5eAPI.Race.URL), RaceChoicePOJO.class);
        } catch (IOException e) {
            raceChoice = new RaceChoicePOJO();
        }
        return raceChoice;
    }

    public TraitChoicePJO getTraitChoices(RaceIndexPOJO characterRace) {
        TraitChoicePJO traitChoice;
        try {
            traitChoice = objectMapper.readValue(new URL(DnD5eAPI.Race.URL + "/" + characterRace.getIndex()), RacePOJO.class).getTraitChoices();
        } catch (IOException e) {
            traitChoice = new TraitChoicePJO();
        }
        return traitChoice;
    }

    public ClassChoicePOJO getClassChoices() {
        ClassChoicePOJO classChoice;
        try {
            classChoice = objectMapper.readValue(new URL(DnD5eAPI.Class.URL), ClassChoicePOJO.class);
        } catch (IOException e) {
            classChoice = new ClassChoicePOJO();
        }
        return classChoice;
    }

    public ProficiencyChoicePOJO getProficiencyChoices(ClassIndexPOJO characterClass) {
        ProficiencyChoicePOJO proficiencyChoice;
        try {
            proficiencyChoice = objectMapper.readValue(new URL(DnD5eAPI.Class.URL + "/" + characterClass.getIndex()), ClassPOJO.class).getProficiencyChoices();
        } catch (IOException e) {
            proficiencyChoice = new ProficiencyChoicePOJO();
        }
        return proficiencyChoice;
    }
}
