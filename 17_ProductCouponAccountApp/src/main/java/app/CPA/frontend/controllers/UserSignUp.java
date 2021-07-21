package app.CPA.frontend.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.CPA.frontend.dao.UserDAO;
import app.CPA.frontend.model.User;

/**
 * Servlet implementation class UserSignUp
 */
@WebServlet("/userSignUp")
public class UserSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao = new UserDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSignUp() {
        super();
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Extract Parameters
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String passwordRepeat = request.getParameter("password_repeat");
		
		RequestDispatcher rd = request.getRequestDispatcher("frontend_views/user/userAccess.jsp");
		
		if (!password.equals(passwordRepeat)) {
			request.setAttribute("status", "Error: Password mismatch");
			rd.forward(request, response);
		}
		
		// Create User Object
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setPassword(password);
		
		boolean isSuccessful = dao.create(newUser);
		
		if (isSuccessful) {
			request.setAttribute("status", "Success: Proceed to login");
		} else {
			request.setAttribute("status", "Error: Invalid username or password");
		}
		rd.forward(request, response);
	}

}
