package com.sinauacademy.hackme.dao;

import com.sinauacademy.hackme.domain.MessageConfig;

public interface MessageConfigDao {
	MessageConfig getMessage(String tableId, String status);
}
