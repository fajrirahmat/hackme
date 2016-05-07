package com.sinauacademy.hackme.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinauacademy.hackme.bean.LoginReply;
import com.sinauacademy.hackme.bean.LoginRequest;
import com.sinauacademy.hackme.domain.User;
import com.sinauacademy.hackme.service.AuthenticationService;
import com.sinauacademy.hackme.service.InvoiceService;

@Controller
public class HomeController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private InvoiceService invoiceService;
	
	@RequestMapping("/login")
	public String welcome(Model model){
		model.addAttribute("login", new LoginRequest());
		model.addAttribute("reply", null);
		return "index";
	}
	
	@RequestMapping( value = "/login", method = RequestMethod.POST)
	public String user(@ModelAttribute("login") LoginRequest loginRequest, Model model, 
			HttpServletRequest request, HttpServletResponse response){
		String username = loginRequest.getUsername();
		String password = loginRequest.getPassword();
		//username = sanitiza(username);
		//password = sanitiza(password);
		
		User user = new User();
		user.setUserId(username);
		user.setPassword(password);
		
		LoginReply reply = authenticationService.authenticated(user);
		
		model.addAttribute("reply", reply);
		if(reply.isAuthenticated()){
			request.getSession().setAttribute("user", user);
			Cookie nameCookie = new Cookie("h_name", user.getName());
			Cookie passwordCookie = new Cookie("fkd", user.getPassword());
			Cookie userId = new Cookie("c_user", user.getUserId());
			nameCookie.setMaxAge(60*60*24);
			passwordCookie.setMaxAge(60*60*24);
			userId.setMaxAge(60*60*24);
			
			response.addCookie(userId);
			response.addCookie(passwordCookie);
			response.addCookie(nameCookie);
			
			return "redirect:/";
		}
		return "index";
	}
	
	@RequestMapping(value = "/logout.html", method= RequestMethod.GET)
	public String logout(HttpServletRequest request, Model model){
		request.getSession().invalidate();
		model.addAttribute("login", new LoginRequest());
		model.addAttribute("reply", null);
		return "index";
	}
	
	static final String allowChars = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890.,+@#$!";

	public String sanitiza(String input){
		String result = "";
		for(int i=0;i<input.length();i++){
			if(allowChars.indexOf(input.charAt(i))>=0){
				result += input.charAt(i);
			}else{
				result += ('\\' + input.charAt(i));
			}
		}
		return result;
	}
	
}
