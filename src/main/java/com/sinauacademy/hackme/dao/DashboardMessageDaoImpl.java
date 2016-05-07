package com.sinauacademy.hackme.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sinauacademy.hackme.domain.DasboardMessage;

@Repository
public class DashboardMessageDaoImpl implements DashboardMessageDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List getAll() {
		// TODO Auto-generated method stub
		List<DasboardMessage> messages = new ArrayList<DasboardMessage>();
		try{
			messages = jdbcTemplate.query("select * from dashboard_message", new BeanPropertyRowMapper(DasboardMessage.class));
		}catch(EmptyResultDataAccessException e){
			System.out.println(e.getMessage());
		}
		return messages;
	}

}
