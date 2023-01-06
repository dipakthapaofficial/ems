package ems;

import java.io.IOException;

public class EmployeeDaoStatic implements EmployeeDaoInterface {
	
	//Storage Point
	static Employee[] employeeList = new Employee[100];
	
	static int index = 0;
	
	static int runningId = 1;
	
	static {
		Employee emp = new Employee();
		emp.setId(runningId++);
		emp.setFirstName("Admin");
		emp.setLastName("Admin");
		emp.setGender(Gender.OTHERS);
		emp.setEmployeeType(EmployeeType.ADMIN);
		emp.setUsername("admin");
		emp.setPassword("admin");
		
		EmployeeDaoStatic.employeeList[EmployeeDaoStatic.index++] = emp;
		
	}
	

	@Override
	public Employee addEmployee(Employee emp) {
		EmployeeDaoStatic.employeeList[EmployeeDaoStatic.index++] = emp;
		
		System.out.println("Employee added successfully!");
		
		return emp;
	}
	
	public void removeEmployee(Employee emp) {
		int index = emp.getId() - 1;
		EmployeeDaoStatic.employeeList[index] = null;
		System.out.println("Removed successfully.");
		
	}
	
	@Override
	public void editEmployee(Employee emp) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void viewAll() throws IOException {
		for (Employee emp : employeeList) {
			if (emp != null) {
				System.out.println(emp);
			}
			
		}
		
	}
	
	@Override
	public Employee searchById(Integer id) throws IOException {
		// TODO Auto-generated method stub
		for (Employee emp : employeeList) {
			if (emp != null && emp.getId() == id) {
				return emp;
			}
		}
		return null;
	}
	
	@Override
	public Employee searchByUsernameAndPassword(String username, String password) throws IOException {
		System.out.println("Inside search by username and password method.. EmployeeDaoStatic");
		for (Employee emp : employeeList) {
			
			if (emp != null && emp.getUsername().equals(username) && emp.getPassword().equals(password)) {
				return emp;
			}
			
		}
		return null;
	}
	
	@Override
	public Employee searchByUsername(String username) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void removeEmployee(String id) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
}
