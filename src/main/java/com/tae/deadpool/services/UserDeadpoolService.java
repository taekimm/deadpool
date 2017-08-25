package com.tae.deadpool.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tae.deadpool.models.userDeadpool;
import com.tae.deadpool.repositories.UserDeadpoolRepository;

@Service
public class UserDeadpoolService {
	@Autowired
	UserDeadpoolRepository UserDeadpoolRepo;
	
	public List<userDeadpool> findAll(){
		return (List<userDeadpool>)UserDeadpoolRepo.findAll();
	}
}
