package com.exercise.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exercise.spring.dao.UserDao;
import com.exercise.spring.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public boolean checkUser(User user) {
		// TODO Auto-generated method stub
		return userDao.checkUser(user);
	}

	@Override
	public void saveOrUpdateUser(User user) {
		// TODO Auto-generated method stub
		userDao.saveOrUpdateUser(user);
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		userDao.deleteUser(userId);
	}

	@Override
	public List<User> getListUser() {
		// TODO Auto-generated method stub
		return userDao.getListUser();
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return userDao.getUserById(userId);
	}

}
