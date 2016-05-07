package com.sinauacademy.hackme.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

public class SessionFilter implements Filter {

	public ServletContext context;
	
	private final String LOGIN_PATH = "/login";
 	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String uri = request.getRequestURI();
		this.context.log("Requested Resource::"+uri);
		HttpSession session = request.getSession(false);
		if((session == null) && !(uri.endsWith("login"))){
			this.context.log("Unauthorized access request");
			this.context.log("Redirect to Login");
			response.sendRedirect(this.context.getContextPath() + LOGIN_PATH);
		}else if(uri.endsWith("login") && session != null){
			response.sendRedirect(this.context.getContextPath() + "/");
		}else{
			chain.doFilter(request, response);
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		this.context = arg0.getServletContext();
	}

}
