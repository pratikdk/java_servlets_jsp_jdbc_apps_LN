package app.CPA.frontend.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SupplierSessionFilter
 */
//@WebFilter("/frontend_views/supplier/supplierHome.jsp")
public class SupplierSessionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SupplierSessionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Supplier filter called");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		
		if (session.getAttribute("supplierUsername") == null) {
			System.out.println("Supplier session is null");
			httpResponse.sendRedirect(httpRequest.getContextPath()+"/frontend_views/supplier/supplierAccess.jsp");
		} else {
		//System.out.println("Supplier session is null but runs");
		// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}

}
