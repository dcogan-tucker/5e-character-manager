package com.sparta.dominic.dungeonsanddragons5echaractermanager.repository;

import com.sparta.dominic.dungeonsanddragons5echaractermanager.entity.ProficiencyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProficiencyRepository extends CrudRepository<ProficiencyEntity, Integer> {
}
