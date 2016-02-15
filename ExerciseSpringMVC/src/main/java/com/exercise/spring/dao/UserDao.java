package com.exercise.spring.dao;

import java.util.List;

import com.exercise.spring.model.User;

public interface UserDao {
	public boolean checkUser(User user);

	public void saveOrUpdateUser(User user);

	public void deleteUser(int userId);

	public List<User> getListUser();
	
	public User getUserById(int userId);
}
