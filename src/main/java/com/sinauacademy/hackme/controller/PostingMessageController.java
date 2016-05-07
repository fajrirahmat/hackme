package com.sinauacademy.hackme.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sinauacademy.hackme.domain.DasboardMessage;
import com.sinauacademy.hackme.service.PostMessageService;

@RestController
@RequestMapping(value = "/message")
public class PostingMessageController {

	@Autowired
	PostMessageService service;
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResponseEntity<List<DasboardMessage>> getMessages(){
		List<DasboardMessage> reply = new ArrayList<DasboardMessage>();
		reply = service.getAll();
		return new ResponseEntity<List<DasboardMessage>>(reply, HttpStatus.OK);
	}
}
