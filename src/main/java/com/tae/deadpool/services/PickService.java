package com.tae.deadpool.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tae.deadpool.models.Character;
import com.tae.deadpool.models.Deadpool;
import com.tae.deadpool.models.Pick;
import com.tae.deadpool.models.User;
import com.tae.deadpool.repositories.CharacterRepository;
import com.tae.deadpool.repositories.DeadpoolRepository;
import com.tae.deadpool.repositories.PickRepository;
import com.tae.deadpool.repositories.UserRepository;

@Service
public class PickService {
	
	private PickRepository pickRepo;
	private DeadpoolRepository deadpoolRepo;
	private UserRepository userRepo;
	private CharacterRepository characterRepo;
	
	public PickService (PickRepository pickRepo, DeadpoolRepository deadpoolRepo, UserRepository userRepo, CharacterRepository characterRepo) {
		this.pickRepo = pickRepo;
		this.deadpoolRepo = deadpoolRepo;
		this.userRepo = userRepo;
		this.characterRepo = characterRepo;
	}
	
	public void updateScores(Long victimId, Long killerId) {
		List<Pick> getAllPicks = (List<Pick>) pickRepo.findAll();
		for (Pick pick : getAllPicks) {
			pickRepo.onePickRight(victimId, pick.getId());
			pickRepo.bothPicksRight(victimId, killerId, pick.getId());
			pickRepo.save(pick);
		}
	}
	
	public List<Object[]> getUsersPicks(Long userId, Long deadpoolId) {
		return pickRepo.getUsersPicks(userId, deadpoolId);
	}
	
	public void createPick(Pick pick, Long userId, Long deadpoolId, Long victimId, Long killerId) {
		User user = userRepo.findOne(userId);
		Deadpool deadpool = deadpoolRepo.findOne(deadpoolId);
		Character victim = characterRepo.findOne(victimId);
		Character killer = characterRepo.findOne(killerId);
		
		pick.setUserPicks(user);
		pick.setRelatedDeadpool(deadpool);
		pick.setKiller(killer);
		pick.setVictim(victim);
		
		pickRepo.save(pick);
	}
}
