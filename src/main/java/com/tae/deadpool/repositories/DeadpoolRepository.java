package com.tae.deadpool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tae.deadpool.models.Deadpool;

@Repository
public interface DeadpoolRepository extends CrudRepository<Deadpool, Long>{
	Deadpool findById(Long deadpoolId);
}
