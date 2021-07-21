package com.udemy.course.CustomTags;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class ResultHandler extends TagSupport {
	private static final long serialVersionUID = 1L;
	// Define constructor and override life-cycle methods
	Connection conn;
	PreparedStatement stmt;

	public ResultHandler() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_test_db", "root", "1234");
			stmt = conn.prepareStatement("select * from user where email=?");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void release() {
		try {
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int doStartTag() throws JspException { // return if body should be processed
		// retrieve the request from the assigned context
		ServletRequest request = pageContext.getRequest();

		String email = request.getParameter("email");

		try {
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			// get output stream
			JspWriter out = pageContext.getOut();
			// Access the result
			if (rs.next()) {
				out.print("User details<br/>");
				out.print("Name: " + rs.getString(1) + "<br/>");
				out.print("Last Name: " + rs.getString(2));
			} else {
				out.print("Invalid email entered");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return TagSupport.SKIP_BODY; // Nope
	}
}
