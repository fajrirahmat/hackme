package com.sinauacademy.hackme.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sinauacademy.hackme.domain.User;

@RestController
public class DummyRestController {

	@RequestMapping(value = "/dummy", method = RequestMethod.GET )
	public ResponseEntity<User> getUser(){
		User reply = new User();
		reply.setName("Fajri Rahmat");
		reply.setUserId("fajri");
		reply.setPassword("12345");
		return new ResponseEntity<User>(reply, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/dummylist", method= RequestMethod.GET)
	public ResponseEntity<List<User>> getUserList(){
		List<User> userList = new ArrayList<User>();
		User reply = new User();
		reply.setName("Fajri Rahmat");
		reply.setUserId("fajri");
		reply.setPassword("12345");
		userList.add(reply);
		reply = new User();
		reply.setName("Anyone");
		reply.setUserId("anyone");
		reply.setPassword("1234gfg5");
		userList.add(reply);
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addummy", method = RequestMethod.POST)
	public ResponseEntity<Void> addDummy(@RequestBody User user, UriComponentsBuilder ucBuilder){
		System.out.println("Create User: " + user.getName());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/hackme/").build().toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
}
