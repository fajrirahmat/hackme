package com.sinauacademy.hackme.bean;


public class LoginReply extends CommonReply {
	private boolean authenticated;
	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}	
}
