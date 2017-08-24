package com.tae.deadpool.services;

import org.springframework.stereotype.Service;

import com.tae.deadpool.repositories.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepo;
	
	public UserService (UserRepository userRepo) {
		this.userRepo = userRepo;
	}
}
