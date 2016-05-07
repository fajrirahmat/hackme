package com.sinauacademy.hackme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinauacademy.hackme.bean.LoginReply;
import com.sinauacademy.hackme.bean.UserReply;
import com.sinauacademy.hackme.domain.User;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private UserService userService;
	
	public LoginReply authenticated(User user) {
		// TODO Auto-generated method stub
		LoginReply reply = new LoginReply();
		try{
			UserReply userReply = userService.checkUserWithPassword(user);
			User userFromDB = userReply.getUser();
			if(userFromDB == null){
				reply.setAuthenticated(false);
				if(userReply.getMessage() != null){
					reply.setMessage(userReply.getMessage());
				}else{
					reply.setMessage("Login Failed");
				}
			}else{
				reply.setAuthenticated(true);
				reply.setMessage("Login Success");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return reply;
	}

}
