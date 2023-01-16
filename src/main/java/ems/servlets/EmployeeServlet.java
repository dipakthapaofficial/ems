package ems.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ems.Employee;
import ems.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EmployeeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Filter alternative
//		Employee employee = (Employee) request.getSession().getAttribute("user");
//		
//		if (employee == null) {
//			//User has not been authenticated yet
////			res.sendRedirect("/ems/login");
//			
//			request.getRequestDispatcher("/login").forward(request, response);
//			
//		} 
		
		System.out.println("Inside get Method.. Employee Servlet");
		// TODO Auto-generated method stub
		EmployeeService emp = new EmployeeService();
		List<Employee> employees = emp.viewAll();
		
		request.setAttribute("employees", employees);
		System.out.println(employees);
		
		request.getRequestDispatcher("employee.jsp").forward(request, response);
//		System.out.println("About to exit do Get method. Employee Servlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Inside do doPost method...");
		
		String method = request.getParameter("method");
		
		//Forwarding call to delete method based on the method passed as parameter. Workaround
		if (method != null && "delete".equals(method)) {
			doDelete(request, response);
		} else {
			doGet(request, response);
		}
		
//		List<String> names = new ArrayList();
//		names.add("Ram");
//		names.add("Ram2");
//		names.add("Ram3");
//		names.add("Ram4");
//		names.add("Ram5");
//		
//		for(String name: names) {
//			
//		}
		
		
		
	}
	
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside do delete method...");
		String id = request.getParameter("id");
		EmployeeService empService = new EmployeeService();
		empService.removeEmployee(id);
		
		//Passing message to front end through send redirect.
		//Set parameter in URL and use request.getParameter in jsp
		String successMessage = "?message=Deleted Successfully!!!";
		
		response.sendRedirect("/ems/employee"+successMessage);
	}

}
