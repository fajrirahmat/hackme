package com.sinauacademy.hackme.dao;

import java.util.List;

import com.sinauacademy.hackme.domain.AccountClassification;

public interface AccountClassificationDao {
	public final static String TABLE_NAME = "ACCOUNT_CLASS";
	AccountClassification findById(String code);
	List getAll();
}
