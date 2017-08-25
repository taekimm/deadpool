package com.tae.deadpool.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tae.deadpool.models.Pick;
import com.tae.deadpool.repositories.PickRepository;

@Service
public class PickService {
	
	private PickRepository pickRepo;
	
	public PickService (PickRepository pickRepo) {
		this.pickRepo = pickRepo;
	}
	
	public void updateScores(Long victimId, Long killerId) {
		List<Pick> getAllPicks = (List<Pick>) pickRepo.findAll();
		for (Pick pick : getAllPicks) {
			pickRepo.onePickRight(victimId, pick.getId());
			pickRepo.bothPicksRight(victimId, killerId, pick.getId());
			pickRepo.save(pick);
		}
	}
}
