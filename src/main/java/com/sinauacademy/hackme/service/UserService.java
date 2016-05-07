package com.sinauacademy.hackme.service;

import java.util.List;

import com.sinauacademy.hackme.bean.UserReply;
import com.sinauacademy.hackme.domain.User;

public interface UserService {
	UserReply checkUserWithPassword(User user);
	List<User> findAll();
	User findById(String userId);
}
