package com.exercise.spring.service;

import java.util.List;

import com.exercise.spring.model.User;

public interface UserService {
	
	public boolean checkUser(User user);

	public void saveOrUpdateUser(User user);

	public void deleteUser(int userId);

	public List<User> getListUser();
	
	public User getUserById(int userId);
}
