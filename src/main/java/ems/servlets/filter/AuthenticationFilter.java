package ems.servlets.filter;

import java.io.IOException;
import java.time.LocalDateTime;

import ems.Employee;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
//@WebFilter(urlPatterns = {"/*"})
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("Inside Do filter method");
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		String path = req.getRequestURI();
		System.out.println("Path:::"+path);
		
		if (path.contains("login")) {
			chain.doFilter(request, response);
		} else {
			
			HttpServletResponse res = (HttpServletResponse) response;
			
			Employee emp = (Employee) req.getSession().getAttribute("user");
			
			LocalDateTime lastActive = (LocalDateTime) req.getSession().getAttribute("lastActive");
			
			LocalDateTime now = LocalDateTime.now();
			
			// (now - lastActive) // Durataion is 10 mintues. Request dispatch to logout 
			
			
			if (emp == null) {
				//User has not been authenticated yet
//				res.sendRedirect("/ems/login");
				
				req.getRequestDispatcher("/login").forward(req, res);
				
			} else {
				// pass the request along the filter chain
				chain.doFilter(request, response);
			}
			
		}
		
		
		
		
		System.out.println("After filter execution...");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
