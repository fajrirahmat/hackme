package com.sinauacademy.hackme.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sinauacademy.hackme.domain.AccountClassification;

public class AccountClassificationMapper implements RowMapper<AccountClassification> {

	public AccountClassification mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		AccountClassification accountClassification = new AccountClassification();
		accountClassification.setCode(rs.getString("code"));
		accountClassification.setName(rs.getString("name"));
		return accountClassification;
	}

}
