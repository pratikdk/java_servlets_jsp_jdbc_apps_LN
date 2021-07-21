package com.udemy.course.CRUDBasics;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateUserServlet
 */
//@WebServlet("/readUsers")
public class ReadUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // DriverManageer auto-instantiate from class object
			connection = DriverManager.getConnection(
					config.getInitParameter("dbUrl"),
					config.getInitParameter("dbUser"),
					config.getInitParameter("dbPassword")
			);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Create Statement
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from user");
			PrintWriter out = response.getWriter();
			out.print("<table>");
			out.print("<tr>");
			out.print("<th>First Name</th>");
			out.print("<th>Last Name</th>");
			out.print("<th>Email</th>");
			out.print("<th>Password</th>");
			out.print("</tr>");
			// Dynamic table
			while (rs.next()) { // Insert a row for each record
				out.print("<tr>");
				out.print("<td>"+ rs.getString(1) +"</td>");
				out.print("<td>"+ rs.getString(2) +"</td>");
				out.print("<td>"+ rs.getString(3) +"</td>");
				out.print("<td>"+ rs.getString(4) +"</td>");
				out.print("</tr>");
			}
			out.print("</table>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
