package ems.servlets;

import java.io.IOException;

import ems.Employee;
import ems.EmployeeType;
import ems.LoginService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoLoginServlet
 */

@WebServlet("/login1")
public class DemoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DemoLoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Hello From DemoLoginServlet").append(request.getContextPath());
		System.out.println("Inside doget method");
		
//		Employee emp = new Employee();
		
		
		response.sendRedirect("login.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		System.out.println("Inside do post method");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password123");
		
		System.out.println("username::"+username);
		System.out.println("password::"+password);
		
		LoginService loginService = new LoginService();
		
		Employee emp = loginService.login(username, password);
		
//		if (emp == null) {
//			response.getWriter().append("Login Failed!!!").append(request.getContextPath());
//		} else {
//			response.getWriter().append("Login SuccessFull").append(request.getContextPath());
//		}
		
		if (emp == null) {
			
			request.setAttribute("error", "Login Failure. Check username and password");
			
			request.setAttribute("username1", username);
			request.setAttribute("password1", password);
			
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
			
//			response.sendRedirect("login.jsp");
		} else {
			if (emp.getEmployeeType() == EmployeeType.ADMIN) {
				response.sendRedirect("admin-dashboard.jsp");
			} else {
				response.sendRedirect("user-dashboard.jsp");
			}
		}
		
		
		
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		System.out.println("Inside do post method");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password123");
		
		System.out.println("username::"+username);
		System.out.println("password::"+password);
		
		LoginService loginService = new LoginService();
		
		Employee emp = loginService.login(username, password);	
		
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		System.out.println("Inside do post method");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password123");
		
		System.out.println("username::"+username);
		System.out.println("password::"+password);
		
		LoginService loginService = new LoginService();
		
		Employee emp = loginService.login(username, password);
		
		
	}

}
