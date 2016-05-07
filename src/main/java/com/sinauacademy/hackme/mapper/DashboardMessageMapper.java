package com.sinauacademy.hackme.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sinauacademy.hackme.domain.DasboardMessage;

public class DashboardMessageMapper implements RowMapper<DasboardMessage> {

	public DasboardMessage mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		DasboardMessage message = new DasboardMessage();
		message.setId(rs.getLong("ID"));
		message.setMessage(rs.getString("MESSAGE"));
		message.setPostDate(rs.getDate("POST_DATE"));
		message.setPostUser(rs.getString("POST_USER"));
		return message;
	}
	
}
