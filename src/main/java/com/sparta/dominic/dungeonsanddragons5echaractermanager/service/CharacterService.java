package com.sparta.dominic.dungeonsanddragons5echaractermanager.service;

import com.sparta.dominic.dungeonsanddragons5echaractermanager.entity.CharacterEntity;
import com.sparta.dominic.dungeonsanddragons5echaractermanager.entity.ProficiencyEntity;
import com.sparta.dominic.dungeonsanddragons5echaractermanager.entity.TraitEntity;
import com.sparta.dominic.dungeonsanddragons5echaractermanager.entity.UserEntity;
import com.sparta.dominic.dungeonsanddragons5echaractermanager.repository.CharacterRepository;
import com.sparta.dominic.dungeonsanddragons5echaractermanager.repository.ProficiencyRepository;
import com.sparta.dominic.dungeonsanddragons5echaractermanager.repository.TraitRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;
    private final ProficiencyRepository proficiencyRepository;
    private final TraitRepository traitRepository;

    public CharacterService(CharacterRepository characterRepository, ProficiencyRepository proficiencyRepository, TraitRepository traitRepository) {
        this.characterRepository = characterRepository;
        this.proficiencyRepository = proficiencyRepository;
        this.traitRepository = traitRepository;
    }

    public void save(CharacterEntity character) {
        String proficiencies = character.getProficienciesString();
        for (String proficiency : proficiencies.split("::")) {
            if (proficiency != "") {
                ProficiencyEntity proficiencyEntity = new ProficiencyEntity();
                proficiencyEntity.setName(proficiency);
                proficiencyEntity.setCharacters(new HashSet<>());
                proficiencyEntity.getCharacters().add(character);
                character.setProficiencies(new HashSet<>());
                character.getProficiencies().add(proficiencyEntity);
            }
        }
        String traits = character.getTraitsString();
        for (String trait : traits.split("::")) {
            if (trait != "") {
                TraitEntity traitEntity = new TraitEntity();
                traitEntity.setName(trait);
                traitEntity.setCharacters(new HashSet<>());
                traitEntity.getCharacters().add(character);
                character.setTraits(new HashSet<>());
                character.getTraits().add(traitEntity);
            }
        }
        characterRepository.save(character);
    }

    public Collection<CharacterEntity> findByUserID(UserEntity user) {
        return characterRepository.findByUserID(user);
    }
}
