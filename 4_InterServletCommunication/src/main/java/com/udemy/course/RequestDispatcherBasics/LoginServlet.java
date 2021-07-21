package com.udemy.course.RequestDispatcherBasics;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;
	
	public void init(ServletConfig config) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/web_test_db", "root", "1234");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from user where email='"+ userName +"' and password='"+ password + "'");
			RequestDispatcher rd = request.getRequestDispatcher("homeServlet");

			if (rs.next()) {
				// redirect to homeServlet
				request.setAttribute("successMessage", "You have successfully logged into your account "+ userName);
				rd.forward(request, response);
			} else {
				// redirect to login page
				request.setAttribute("failureMessage", "Invalid Credentials, re-enter your valid Username and Password");
				rd = request.getRequestDispatcher("login.html");
				rd.include(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
