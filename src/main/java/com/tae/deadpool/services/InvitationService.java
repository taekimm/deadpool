package com.tae.deadpool.services;

import org.springframework.stereotype.Service;

import com.tae.deadpool.repositories.InvitationRepository;

@Service
public class InvitationService {
	
	private InvitationRepository invitationRepo;
	
	public InvitationService (InvitationRepository invitationRepo) {
		this.invitationRepo = invitationRepo;
	}
}
