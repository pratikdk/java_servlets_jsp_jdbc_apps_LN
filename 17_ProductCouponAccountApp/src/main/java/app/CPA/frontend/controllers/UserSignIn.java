package app.CPA.frontend.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.CPA.frontend.dao.UserDAO;
import app.CPA.frontend.model.User;

/**
 * Servlet implementation class UserSignIn
 */
@WebServlet("/userSignIn")
public class UserSignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO dao = new UserDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		// if user session is set redirect to some user page
//		// else redirect to userlogin page
//		if (session.getAttribute("userUsername") != null) {
//			
//		} else {
//			response.sendRedirect(request.getContextPath()+"/frontend_views/user/userAccess.jsp");
//		}
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Extract Parameters
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// Create User Object
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		// find user
		boolean hasFound = dao.find(user);
		
		if (hasFound) {
			HttpSession session = request.getSession();
			session.setAttribute("userObj", user);
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("userUsername", user.getUsername());
			
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			//request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			request.setAttribute("status", "Error: Invalid username or password");
			request.getRequestDispatcher("frontend_views/user/userAccess.jsp").forward(request, response);
		}
	}
}
