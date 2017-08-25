package com.tae.deadpool.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tae.deadpool.models.Pick;

@Repository
@Transactional
public interface PickRepository extends CrudRepository<Pick, Long> {
	 
	@Modifying
	@Query("update Pick p set p.score = 5 WHERE p.victim = ?1 AND p.id = ?2")
	int onePickRight(Long victimId, Long pickId);
	
	@Modifying
	@Query("update Pick p set p.score = 10 WHERE p.victim = ?1 AND p.killer = ?2 AND p.id = ?3")
	int bothPicksRight(Long victimId, Long killerId, Long pickId);
}
