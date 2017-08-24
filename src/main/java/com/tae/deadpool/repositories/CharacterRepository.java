package com.tae.deadpool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tae.deadpool.models.Character;

@Repository
public interface CharacterRepository extends CrudRepository<Character, Long> {

}
