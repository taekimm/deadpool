package com.tae.deadpool.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tae.deadpool.models.Character;
import com.tae.deadpool.repositories.CharacterRepository;

@Service
@Transactional
public class CharacterService {
	
	@Autowired
	CharacterRepository characterRepository;
	
	public void saveChar(Character character) {
		characterRepository.save(character);
	}
	
	private static final int PAGE_SIZE = 10;
    
    public Page<Character> charactersPerPage(int pageNumber) {
        PageRequest pageRequest = new PageRequest(pageNumber, PAGE_SIZE, Sort.Direction.ASC, "lname");
        Page<Character> characters = characterRepository.findAll(pageRequest);
        return characterRepository.findAll(pageRequest);
    }

	public Character getCharById(Long characterId) {
		return characterRepository.findOne(characterId);
	}
	
}
