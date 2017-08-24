package com.tae.deadpool.services;

import org.springframework.stereotype.Service;

import com.tae.deadpool.repositories.PickRepository;

@Service
public class PickService {
	
	private PickRepository pickRepo;
	
	public PickService (PickRepository pickRepo) {
		this.pickRepo = pickRepo;
	}
}
