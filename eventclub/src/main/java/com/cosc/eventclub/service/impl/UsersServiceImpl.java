package com.cosc.eventclub.service.impl;

import org.springframework.stereotype.Service;

import com.cosc.eventclub.entity.UsersEntity;
import com.cosc.eventclub.repository.UsersRepository;
import com.cosc.eventclub.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	private final UsersRepository usersRepo;
	
	public UsersServiceImpl(UsersRepository usersRepo) {
		this.usersRepo=usersRepo;
	}
	@Override
	public UsersEntity getUser(String username) {
		
		return usersRepo.findByUsername(username);
	}
	@Override
	public UsersEntity addUser(UsersEntity user) {
		return usersRepo.save(user);
		
	}
	@Override
	public UsersEntity login(String username, String password) {
		UsersEntity user=usersRepo.findByUsername(username);
		System.out.println(user);
		if(user!=null && user.getPassword().equals(password)) {
			return new UsersEntity(user.getUserId(), user.getUsername(), user.getUserRole());
		}
		return null;
	}

}
