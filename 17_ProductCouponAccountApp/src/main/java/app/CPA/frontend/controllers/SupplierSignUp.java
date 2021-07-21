package app.CPA.frontend.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.CPA.frontend.dao.SupplierDAO;
import app.CPA.frontend.model.Supplier;

/**
 * Servlet implementation class SupplierSignUp
 */
@WebServlet("/supplierSignUp")
public class SupplierSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SupplierDAO dao = new SupplierDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierSignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Extract Parameters
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String passwordRepeat = request.getParameter("password_repeat");
		
		RequestDispatcher rd = request.getRequestDispatcher("frontend_views/supplier/supplierAccess.jsp");
		
		if (!password.equals(passwordRepeat)) {
			request.setAttribute("status", "Error: Password mismatch");
			rd.forward(request, response);
		}
		
		// Create Supplier Object
		Supplier newSupplier = new Supplier();
		newSupplier.setUsername(username);
		newSupplier.setPassword(password);
		
		boolean isSuccessful = dao.create(newSupplier);
		
		if (isSuccessful) {
			request.setAttribute("status", "Success: Proceed to login");
		} else {
			request.setAttribute("status", "Error: Invalid username or password");
		}
		rd.forward(request, response);
	}

}
