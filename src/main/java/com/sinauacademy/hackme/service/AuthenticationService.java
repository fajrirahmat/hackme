package com.sinauacademy.hackme.service;

import com.sinauacademy.hackme.bean.LoginReply;
import com.sinauacademy.hackme.domain.User;

public interface AuthenticationService {
	LoginReply authenticated(User user);
}
