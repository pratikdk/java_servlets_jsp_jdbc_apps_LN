package app.CPA.frontend.controllers;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.CPA.frontend.dao.ProductDAO;
import app.CPA.frontend.model.Product;

/**
 * Servlet implementation class CreateProduct
 */
@WebServlet("/createProduct")
public class CreateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductDAO dao = new ProductDAO();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProduct() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Extract params
		int productTypeId = Integer.parseInt(request.getParameter("productType"));
		int supplierId = Integer.parseInt(request.getParameter("supplierId"));
		String productName = request.getParameter("productName");
		BigDecimal productPrice = new BigDecimal(request.getParameter("productPrice"));
		
		// Create Product obj
		Product newProduct = new Product();
		newProduct.setProductTypeId(productTypeId);
		newProduct.setSupplierId(supplierId);
		newProduct.setProductName(productName);
		newProduct.setProductPrice(productPrice);
		
		boolean isSuccessful = dao.create(newProduct);
		
		RequestDispatcher rd = request.getRequestDispatcher("frontend_views/supplier/createProduct.jsp");
		
		if (isSuccessful) {
			request.setAttribute("status", "Success: Product successfully created");
		} else {
			request.setAttribute("status", "Error: Invalid product details");
		}
		rd.forward(request, response);
	}

}
