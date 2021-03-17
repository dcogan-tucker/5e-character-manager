package com.sparta.dominic.dungeonsanddragons5echaractermanager.repository;

import com.sparta.dominic.dungeonsanddragons5echaractermanager.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findByUsername(String username);
}
