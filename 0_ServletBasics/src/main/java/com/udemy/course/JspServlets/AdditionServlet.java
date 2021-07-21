package com.udemy.course.JspServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AdditionServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		if (request.getParameter("number1") != null && request.getParameter("number2") != null) {
			Long number1 = Long.parseLong(request.getParameter("number1"));
			Long number2 = Long.parseLong(request.getParameter("number2"));
			PrintWriter out = response.getWriter();
			out.println("The Result is: " + (number1 + number2));
		}
	}

}
