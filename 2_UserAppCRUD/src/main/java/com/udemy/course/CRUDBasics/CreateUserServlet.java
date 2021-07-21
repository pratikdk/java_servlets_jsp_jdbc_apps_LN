package com.udemy.course.CRUDBasics;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet(urlPatterns="/createUser", initParams = {
		@WebInitParam(name = "dbUrl", value = "jdbc:mysql://localhost/web_test_db"),
		@WebInitParam(name = "dbUser", value = "root"),
		@WebInitParam(name = "dbPassword", value = "1234")
})
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) {
		try {
			ServletContext servletContext = config.getServletContext();
			Enumeration<String> parameterNames = servletContext.getInitParameterNames();
			
//			Iterator<String> parameterIterator = parameterNames.asIterator();
//			while (parameterIterator.hasNext()) {
//				String attributeName = parameterIterator.next();
//				System.out.println("-> " + attributeName + " = " + servletContext.getInitParameter(attributeName));
//			}
			
//			String parameterName;
//			while ((parameterName = parameterNames.nextElement()) != null) {
//				System.out.println("-> " + parameterName + " = " + servletContext.getInitParameter(parameterName));
//			}
			
			while (parameterNames.hasMoreElements()) {
				String parameterName = parameterNames.nextElement();
				System.out.println("-> " + parameterName + " = " + servletContext.getInitParameter(parameterName));
			}
			
			Class.forName("com.mysql.cj.jdbc.Driver"); // DriverManageer auto-instantiate from class object
			connection = DriverManager.getConnection(
					config.getInitParameter("dbUrl"),
					config.getInitParameter("dbUser"),
					config.getInitParameter("dbPassword"));
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// Create Statement
		try {
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate("insert into user values('"+firstName+"', '"+lastName+"', '"+email+"', '"+password+"')");
			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.println("<h1>User successfully created</h1>");
			} else {
				out.println("<h1>Error creating new user</h1>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
