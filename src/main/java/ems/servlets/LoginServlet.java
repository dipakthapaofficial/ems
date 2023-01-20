package ems.servlets;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.xml.ws.Response;

import ems.Employee;
import ems.EmployeeType;
import ems.LoginService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

//		System.out.println(request.getContextPath());
		String name = request.getParameter("name");
//		System.out.println(name);
		System.out.println("Inside do get method on login servlet");

		if (name != null) {
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("demo/login.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("username:::" + username);
		System.out.println("password::"+ password);
		
		LoginService loginService = new LoginService();
		Employee emp = loginService.login(username, password);
		
		if (emp != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", emp);
			session.setAttribute("lastActive", LocalDateTime.now());
		}
		
		if  (emp != null && emp.getEmployeeType() == EmployeeType.ADMIN) {
			
			response.sendRedirect("admin-dashboard.jsp");
		} else if (emp != null && emp.getEmployeeType() == EmployeeType.USER) {
			response.sendRedirect("user-dashboard.jsp");
		}else {
			response.sendRedirect("demo/login.jsp");
		}
		
	}

}
