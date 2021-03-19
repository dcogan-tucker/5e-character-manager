package com.sparta.dominic.dungeonsanddragons5echaractermanager.repository;

import com.sparta.dominic.dungeonsanddragons5echaractermanager.entity.CharacterEntity;
import com.sparta.dominic.dungeonsanddragons5echaractermanager.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CharacterRepository extends CrudRepository<CharacterEntity, Integer> {

    @Query("SELECT c FROM CharacterEntity c WHERE c.user = :user")
    Collection<CharacterEntity> findByUserID(@Param("user")UserEntity user);
}
