package com.sinauacademy.hackme.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sinauacademy.hackme.domain.User;

public class UserMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		User user = new User();
		System.out.println(rs.wasNull());
		if(!rs.wasNull()){
			user.setUserId(rs.getString("user_id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
		}
		return user;
	}

}
