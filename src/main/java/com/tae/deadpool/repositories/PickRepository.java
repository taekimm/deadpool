package com.tae.deadpool.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tae.deadpool.models.Pick;

@Repository
@Transactional
public interface PickRepository extends CrudRepository<Pick, Long> {
	 
	@Query(value="SELECT SUM(picks.score) FROM picks WHERE deadpool_id = ?1 AND user_id = ?2 GROUP BY user_id", nativeQuery=true)
	Integer sumScore(Long deadpoolId, Long userId);
	
	@Modifying
	@Query("update Pick p set p.score = 5 WHERE p.victim.id = ?1 AND p.id = ?2")
	int onePickRight(Long victimId, Long pickId);
	
	@Modifying
	@Query("update Pick p set p.score = 10 WHERE p.victim.id = ?1 AND p.killer.id = ?2 AND p.id = ?3")
	int bothPicksRight(Long victimId, Long killerId, Long pickId);
	
	@Query("SELECT p FROM Pick p WHERE p.userPicks = ?1 AND p.relatedDeadpool = ?2")
	List<Object[]> getUsersPicks(Long userId, Long deadpoolId);
}
