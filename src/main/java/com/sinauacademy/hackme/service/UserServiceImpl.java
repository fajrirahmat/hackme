package com.sinauacademy.hackme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinauacademy.hackme.bean.UserReply;
import com.sinauacademy.hackme.dao.UserDao;
import com.sinauacademy.hackme.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	public UserReply checkUserWithPassword(User user) {
		// TODO Auto-generated method stub
		return userDao.findUserWithPassword(user);
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public User findById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
