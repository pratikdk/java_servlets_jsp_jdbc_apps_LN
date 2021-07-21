package com.udemy.course.Session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie: cookies) {
			System.out.println(cookie.getName() + " -> " + cookie.getValue());
		}
		
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.print("Welcome " + userName + " to /targetServlet.");
	}
	
	
}
