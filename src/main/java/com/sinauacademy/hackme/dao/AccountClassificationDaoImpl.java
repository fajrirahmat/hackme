package com.sinauacademy.hackme.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sinauacademy.hackme.domain.AccountClassification;
import com.sinauacademy.hackme.mapper.AccountClassificationMapper;

public class AccountClassificationDaoImpl implements AccountClassificationDao {
	
	private final static String FIND_BY_ID_QUERY = "SELECT CODE, NAME FROM " + TABLE_NAME + " WHERE CODE = ?";
	private final static String GET_ALL_QUERY = "SELECT CODE, NAME FROM " + TABLE_NAME;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public AccountClassification findById(String code) {
		// TODO Auto-generated method stub
		try{
			return jdbcTemplate.queryForObject(FIND_BY_ID_QUERY, new Object[]{code}, new AccountClassificationMapper());
		}catch(EmptyResultDataAccessException ex){
			System.out.println(ex.getMessage());
		}
		return null;
	}

	public List getAll() {
		List<AccountClassification> result = new ArrayList<AccountClassification>();
		try{
			result = jdbcTemplate.query(GET_ALL_QUERY, new BeanPropertyRowMapper(AccountClassification.class));
		}catch(EmptyResultDataAccessException ex){
			System.out.println(ex.getMessage());
		}
		return result;
	}

}
