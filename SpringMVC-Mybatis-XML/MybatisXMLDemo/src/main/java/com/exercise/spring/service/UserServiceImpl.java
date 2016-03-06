package com.exercise.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.spring.mapper.UserMapper;
import com.exercise.spring.model.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	public User checkUser(User user) {
		return userMapper.checkUser(user);
	}
}
