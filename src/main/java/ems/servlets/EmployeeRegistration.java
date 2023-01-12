package ems.servlets;

import java.io.IOException;
import java.sql.SQLException;

import ems.Employee;
import ems.EmployeeService;
import ems.EmployeeType;
import ems.Gender;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeRegistration
 */
@WebServlet("/register")
public class EmployeeRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EmployeeRegistration() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getRequestURI());
		
		String id = request.getParameter("id");
		System.out.println("ID::"+id);
		
		int empId= 0;
		if (id != null && id != "") {
			empId = Integer.parseInt(id);
		}
		
		if (empId == 0) {
			response.sendRedirect("emp-registration.jsp");
		} else {
			// Get employee value
			
			EmployeeService employeeService = new EmployeeService();
			Employee emp = employeeService.findById(empId);
			
			request.setAttribute("id", emp.getId());
			request.setAttribute("firstName", emp.getFirstName());
			request.setAttribute("lastName", emp.getLastName());
			request.setAttribute("username", emp.getFirstName());
			request.setAttribute("password", emp.getFirstName());
			request.setAttribute("gender", emp.getGender());
			
			request.setAttribute("employee", emp);
			request.getRequestDispatcher("emp-registration.jsp").forward(request, response);
			
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Inside post method");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String gender = request.getParameter("gender");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		EmployeeType type = EmployeeType.USER;
		Gender g = Gender.getByValue(gender);
		
		Employee emp1 = new Employee(firstName, lastName, g, username, password, type);
		
		EmployeeService emService = new EmployeeService();
		
		if (emService.checkIfUserNameExists(username)) {
			System.out.println("This username has been taken.");
			
			request.setAttribute("error", "This username has been taken. Pick another username.");
			
			request.setAttribute("firstName", firstName);
			request.setAttribute("lastName", lastName);
			request.setAttribute("gender", gender);
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			
//			request.setAttribute("employee", emp1);
			
			RequestDispatcher rd = request.getRequestDispatcher("/emp-registration.jsp");
			rd.forward(request, response);
			
			return;
		}
		
		try {
			
			String id = request.getParameter("id");
			System.out.println("ID::"+id);
			
			int empId= 0;
			if (id != null && id != "") {
				empId = Integer.parseInt(id);
			}
			emp1.setId(empId);
			
//			emp1.setUsername("dipak");
			
			if (empId == 0) {
				emService.addEmployee(emp1);
			} else {
				emService.editProfile(emp1);
			}
			
		} catch (ClassNotFoundException | IOException | SQLException e) {
			request.setAttribute("internalError", "Internal Server error. Please contact your admin!!!");
			e.getStackTrace();
			request.setAttribute("firstName", firstName);
			request.setAttribute("lastName", lastName);
			request.setAttribute("gender", gender);
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			
			request.setAttribute("employee", emp1);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
			
			return;
		}
		
		response.sendRedirect("https://google.com");
		
		
		
	}

}
