package com.exercise.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;


@SuppressWarnings("serial")
@Entity
public class User implements Serializable {
	private int userId;

	private String username;

	private String password;

	private int groupUser;

	public User() {
		super();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getGroupUser() {
		return groupUser;
	}

	public void setGroupUser(int groupUser) {
		this.groupUser = groupUser;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username
				+ ", password=" + password + ", groupUser=" + groupUser + "]";
	}

}
