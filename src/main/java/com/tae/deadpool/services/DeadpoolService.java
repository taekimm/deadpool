package com.tae.deadpool.services;

import org.springframework.stereotype.Service;

import com.tae.deadpool.models.Deadpool;
import com.tae.deadpool.repositories.DeadpoolRepository;

@Service
public class DeadpoolService {
	
	private DeadpoolRepository deadpoolRepo;
	
	public DeadpoolService (DeadpoolRepository deadpoolRepo) {
		this.deadpoolRepo = deadpoolRepo;
	}
	
	public Deadpool findById(Long deadpoolId) {
		return deadpoolRepo.findOne(deadpoolId);
	}
}
