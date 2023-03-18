package com.cosc.eventclub.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosc.eventclub.controller.dao.LoginDao;
import com.cosc.eventclub.entity.UsersEntity;
import com.cosc.eventclub.service.UsersService;

@RestController
@RequestMapping("/v1")
public class UsersController {
	
	public final UsersService usersService;
	
	public UsersController(UsersService usersService) {
		this.usersService=usersService;
	}
	
	@PostMapping
	public UsersEntity addUser(@RequestBody UsersEntity user) {
		return usersService.addUser(user);
	}
	
	@GetMapping("{username}")
	public UsersEntity getUser(@PathVariable("username")  String username) {
		return usersService.getUser(username);
	}
	
	@PostMapping("/login")
	public UsersEntity login(@RequestBody LoginDao loginDao) {
		return usersService.login(loginDao.getUsername(),loginDao.getPassword());
	}

}
