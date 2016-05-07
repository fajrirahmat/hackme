package com.sinauacademy.hackme.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sinauacademy.hackme.domain.MessageConfig;

@Repository
public class MessageConfigDaoImpl implements MessageConfigDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public MessageConfig getMessage(String tableId, String status) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
