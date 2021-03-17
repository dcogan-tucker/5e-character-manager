package com.sparta.dominic.dungeonsanddragons5echaractermanager.repository;

import com.sparta.dominic.dungeonsanddragons5echaractermanager.entity.CharacterEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends CrudRepository<CharacterEntity, Integer> {
}
