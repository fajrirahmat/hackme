package com.sinauacademy.hackme.dao;

import com.sinauacademy.hackme.bean.UserReply;
import com.sinauacademy.hackme.domain.User;

public interface UserDao {
	UserReply findUserWithPassword(User user);
}
