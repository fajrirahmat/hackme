package com.sinauacademy.hackme.bean;

import com.sinauacademy.hackme.domain.User;

public class UserReply extends CommonReply {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
