package com.sparta.dominic.dungeonsanddragons5echaractermanager.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.dominic.dungeonsanddragons5echaractermanager.pojo.*;
import com.sparta.dominic.dungeonsanddragons5echaractermanager.utill.DnD5eAPI;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

@Service
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

    public Collection<TraitChoicePJO> getTraitChoices(String characterRace) {
        Collection<TraitChoicePJO> traitChoice = new ArrayList<>();
        try {
            if (characterRace != null) {
                TraitChoicePJO traitPOJO = objectMapper.readValue(new URL(DnD5eAPI.Race.URL + "/" + characterRace.toLowerCase()), RacePOJO.class).getTraitChoices();
                if (traitPOJO != null) {
                    traitChoice.add(traitPOJO);
                }
            }
        } catch (IOException e) {
            traitChoice = new ArrayList<>();
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

    public Collection<ProficiencyChoicePOJO> getProficiencyChoices(String characterClass) {
        Collection<ProficiencyChoicePOJO> proficiencyChoice = new ArrayList<>();
        try {
            if (characterClass != null) {
                proficiencyChoice = objectMapper.readValue(new URL(DnD5eAPI.Class.URL + "/" + characterClass.toLowerCase()), ClassPOJO.class).getProficiencyChoices();
            }
        } catch (IOException e) {
            proficiencyChoice = new ArrayList<>();
        }
        return proficiencyChoice;
    }
}
