package com.sinauacademy.hackme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinauacademy.hackme.dao.DashboardMessageDao;

@Service
public class PostMessageServiceImpl implements PostMessageService {

	@Autowired
	DashboardMessageDao messageDao;
	
	public List getAll() {
		// TODO Auto-generated method stub
		return messageDao.getAll();
	}

}
