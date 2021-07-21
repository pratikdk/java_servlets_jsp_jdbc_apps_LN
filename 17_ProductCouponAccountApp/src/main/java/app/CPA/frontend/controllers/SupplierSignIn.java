package app.CPA.frontend.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.CPA.frontend.dao.SupplierDAO;
import app.CPA.frontend.model.Supplier;

/**
 * Servlet implementation class SupplierSignIn
 */
@WebServlet("/supplierSignIn")
public class SupplierSignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SupplierDAO dao = new SupplierDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierSignIn() {
        super();
        // TODO Auto-generated constructor stub
    }
    
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		// if user session is set redirect to some supplier page
//		// else redirect to supplier login page
//		if (session.getAttribute("supplierUsername") != null) {
//			
//		} else {
//			response.sendRedirect(request.getContextPath()+"/frontend_views/supplier/supplierAccess.jsp");
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
		Supplier supplier = new Supplier();
		supplier.setUsername(username);
		supplier.setPassword(password);
		
		// find user
		boolean hasFound = dao.find(supplier);
		
		if (hasFound) {
			HttpSession session = request.getSession();
			session.setAttribute("supplierObj", supplier);
			session.setAttribute("supplierId", supplier.getSupplierId());
			session.setAttribute("supplierUsername", supplier.getUsername());
			
			response.sendRedirect("frontend_views/supplier/supplierHome.jsp");
			//request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			request.setAttribute("status", "Error: Invalid username or password");
			request.getRequestDispatcher("frontend_views/supplier/supplierAccess.jsp").forward(request, response);
		}
	}

}
