package com.cosc.eventclub.service;

import com.cosc.eventclub.entity.UsersEntity;

public interface UsersService {
	
	UsersEntity getUser(String username);

	UsersEntity addUser(UsersEntity user);

	UsersEntity login(String username, String password);

}
