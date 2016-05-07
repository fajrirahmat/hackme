package com.sinauacademy.hackme.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinauacademy.hackme.escape.ValidatorOutput;

public class BypassFIlter implements Filter {

	
	static final String allowChars = "qwertyuiopasdfghjklzxcvbnm+@#$!";
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

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
	
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse respnse = (HttpServletResponse) arg1;
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username != null){
			request.setAttribute("username", sanitiza(username));
		}
		if(password != null){
			request.setAttribute("password", sanitiza(password));
		}
		
		arg2.doFilter(request, respnse);
		
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
