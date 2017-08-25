package com.tae.deadpool.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tae.deadpool.models.Deadpool;
import com.tae.deadpool.models.User;
import com.tae.deadpool.repositories.DeadpoolRepository;
import com.tae.deadpool.repositories.UserRepository;

@Service
public class DeadpoolService {
	
	private DeadpoolRepository deadpoolRepo;
	private UserRepository userRepo;
	
	public DeadpoolService (DeadpoolRepository deadpoolRepo, UserRepository userRepo) {
		this.deadpoolRepo = deadpoolRepo;
		this.userRepo = userRepo;
	}
	
	public Deadpool findById(Long deadpoolId) {
		return deadpoolRepo.findOne(deadpoolId);
	}
	
	public void inviteUser(Deadpool deadpool, User invitedUser) {
		List<Deadpool> userPoolInvites = invitedUser.getInvitedDeadpools();
		if(userPoolInvites == null) {
			List<Deadpool> newUserInvites = new ArrayList<Deadpool>();
			newUserInvites.add(deadpool);
			invitedUser.setInvitedDeadpools(newUserInvites);
		} else {
			userPoolInvites.add(deadpool);
			invitedUser.setInvitedDeadpools(userPoolInvites);
		}
			userRepo.save(invitedUser);
			deadpoolRepo.save(deadpool);
	}
	
	public void addUser(Deadpool deadpool, User user) {
		List<User> invitedUsers = deadpool.getInvitedUsersInDeadpool();
		List<Deadpool> invitedDeadpools = user.getInvitedDeadpools();
		List<Deadpool> deadpoolToRemove = new ArrayList<Deadpool>();
		for(Deadpool d : invitedDeadpools) {
			if(d.getId().equals(deadpool.getId())) {
				deadpoolToRemove.add(d);
			}
		}
		deadpool.getUsersInDeadpool().add(user);
		invitedDeadpools.removeAll(deadpoolToRemove);
		userRepo.save(user);
		deadpoolRepo.save(deadpool);
	}
	public void saveDeadpool(Deadpool deadpool, User host) {
		deadpool.setHost(host);
		List<User> usersInDeadpool = new ArrayList<User>();
		usersInDeadpool.add(host);
		deadpool.setUsersInDeadpool(usersInDeadpool);
		deadpoolRepo.save(deadpool);
	}
	
	public Deadpool getDeadpoolById(Long deadpoolId) {
		return deadpoolRepo.findById(deadpoolId);
	}
}
