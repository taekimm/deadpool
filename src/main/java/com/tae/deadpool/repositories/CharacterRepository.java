package com.tae.deadpool.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tae.deadpool.models.Character;

@Repository
@Transactional
public interface CharacterRepository extends PagingAndSortingRepository<Character, Long> {
    
    @Modifying
    @Query("update Character c set c.fname =  ?1, c.lname = ?2, c.alive = ?3 WHERE c.id = ?4")
    int updateCharacter(String fname, String lname, boolean alive, Long id);
}