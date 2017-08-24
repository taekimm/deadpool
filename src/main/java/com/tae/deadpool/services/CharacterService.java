package com.tae.deadpool.services;

import org.springframework.stereotype.Service;

import com.tae.deadpool.repositories.CharacterRepository;

@Service
public class CharacterService {
	
	private CharacterRepository characterRepo;
	
	public CharacterService (CharacterRepository characterRepo) {
		this.characterRepo = characterRepo;
	}
}
