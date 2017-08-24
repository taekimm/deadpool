package com.tae.deadpool.services;

import org.springframework.stereotype.Service;

import com.tae.deadpool.repositories.RoleRepository;

@Service
public class RoleService {
	private RoleRepository roleRepository;
	
	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
}