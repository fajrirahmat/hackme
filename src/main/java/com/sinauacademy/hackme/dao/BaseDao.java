package com.sinauacademy.hackme.dao;

import java.util.List;

public interface BaseDao {
	void insert(Object object);
	void update(Object object);
	Object findById(String id);
	List getAll();
}
