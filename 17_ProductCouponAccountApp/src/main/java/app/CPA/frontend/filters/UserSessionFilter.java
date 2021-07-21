package app.CPA.frontend.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class UserSessionFilter
 */
@WebFilter("/UserSessionFilter")
public class UserSessionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UserSessionFilter() {
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("User filter called");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		
		if (session.getAttribute("userUsername") == null) {
			System.out.println("User session is null");
			httpResponse.sendRedirect(httpRequest.getContextPath()+"/frontend_views/user/userAccess.jsp");
		} else {
			//System.out.println("Supplier session is null but runs");
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}


}
