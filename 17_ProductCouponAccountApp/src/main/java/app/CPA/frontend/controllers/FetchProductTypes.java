package app.CPA.frontend.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.CPA.frontend.dao.ProductTypesDAO;

/**
 * Servlet implementation class FetchProductTypes
 */
@WebServlet("/fetchProductTypes")
public class FetchProductTypes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductTypesDAO dao = new ProductTypesDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchProductTypes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Invoked fetch product types");
		request.setAttribute("fetchedProductTypes", dao.selectAll());
	}
}
