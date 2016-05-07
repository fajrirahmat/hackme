package com.sinauacademy.hackme.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sinauacademy.hackme.bean.UserReply;
import com.sinauacademy.hackme.domain.User;
import com.sinauacademy.hackme.mapper.UserMapper;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public UserReply findUserWithPassword(User user) {
		// TODO Auto-generated method stubor
		//it's vunarable. please don't use this code in your product
		String sql = "select * from user where user_id='" +user.getUserId()+ "' and password=password('"+user.getPassword()+"')";
		System.out.println(sql);
		UserReply reply = new UserReply();
		User userReturn = null;
		try{
			userReturn = jdbcTemplate.queryForObject(sql, new UserMapper());
			//return userReturn;	
		}catch(EmptyResultDataAccessException ex){
			System.out.println("ERROR: " + ex.getMessage());
		//	reply.setMessage(ex.getMessage());
		}catch(Exception e){
			System.out.println("ERROR: " + e.getMessage());
			reply.setMessage(e.getMessage());
		}
		reply.setUser(userReturn);
		return reply;
	}

}
