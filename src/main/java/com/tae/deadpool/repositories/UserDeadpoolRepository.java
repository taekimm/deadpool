package com.tae.deadpool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tae.deadpool.models.userDeadpool;

@Repository
public interface UserDeadpoolRepository extends CrudRepository<userDeadpool, Long> {
	
}
