package ems.servlets.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(filterName ="authFilter", urlPatterns = {"/employee", "/register"})
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("Inside filter");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		if (req.getSession().getAttribute("user") != null) {
			System.out.println("Logged in");
			chain.doFilter(request, response);
		} else {
			System.out.println("Not logged in");
			
			System.out.println(req.getRequestURL());
			System.out.println(req.getRequestURI());
			System.out.println(req.getServerName());
			res.sendRedirect("login");
		}
		
		
		System.out.println("After filter");

	}

}
