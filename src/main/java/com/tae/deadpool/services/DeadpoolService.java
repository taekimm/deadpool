package com.tae.deadpool.services;

import org.springframework.stereotype.Service;

import com.tae.deadpool.repositories.DeadpoolRepository;

@Service
public class DeadpoolService {
	
	private DeadpoolRepository deadpoolRepo;
	
	public DeadpoolService (DeadpoolRepository deadpoolRepo) {
		this.deadpoolRepo = deadpoolRepo;
	}
}
