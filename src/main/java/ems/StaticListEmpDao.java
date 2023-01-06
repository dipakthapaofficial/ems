package ems;

import java.io.IOException;

public class StaticListEmpDao implements EmployeeDaoInterface {
	
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
	public void editEmployee(Employee emp) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void viewAll() throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Employee searchById(Integer id) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Employee searchByUsernameAndPassword(String username, String password) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Employee addEmployee(Employee emp) throws IOException {
		EmployeeDaoStatic.employeeList[EmployeeDaoStatic.index++] = emp;
		
		System.out.println("Employee added successfully!");
		
		return emp;
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
