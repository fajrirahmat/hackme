package com.sinauacademy.hackme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashboardController {
	@RequestMapping(value = "/", method = RequestMethod.GET )
	public String home(Model model){
		return "home";
	}
}
