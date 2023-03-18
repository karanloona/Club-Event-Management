package com.cosc.eventclub.entity;

import javax.persistence.*;

@Entity
@Table(name="users")
public class UsersEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	@Column(name="username")
	private String username;
	@Column(name="user_role")
	private String userRole;
	@Column(name="password")
	private String password;
	
	public UsersEntity() {
		
	}
	public UsersEntity(int userId, String username, String userRole, String password) {
		this.userId = userId;
		this.username = username;
		this.userRole = userRole;
		this.password = password;
	}
	
	public UsersEntity(int userId, String username, String userRole) {
		this.userId = userId;
		this.username = username;
		this.userRole = userRole;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
