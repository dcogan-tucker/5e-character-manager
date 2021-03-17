package com.sparta.dominic.dungeonsanddragons5echaractermanager.repository;

import com.sparta.dominic.dungeonsanddragons5echaractermanager.entity.TraitEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraitRepository extends CrudRepository<TraitEntity, Integer> {
}
