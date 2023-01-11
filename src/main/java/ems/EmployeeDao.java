package ems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EmployeeDao implements EmployeeDaoInterface {
	
	/**
	 * Directly searching and replacing is not possible, we copy the content of file in string
	 * builder, then replace the content in builder. Then write the existing again in create mode
	 * and replace with value stored in builder
	 * 
	 * @param emp
	 * @throws IOException
	 */
	@Override
	public void editEmployee(Employee emp) throws IOException {
		//Find the line, store it in string builder and replace the content with new employee object
		BufferedReader reader = new BufferedReader(new FileReader("employee.txt"));
		String line = reader.readLine();
		StringBuilder builder = new StringBuilder();
		while (line != null) {
			String[] values = line.split(", ");
			boolean matches = false;
			for (String val : values) {
				if (val.contains("id") && val.equals("id=" + emp.getId())) {
					matches = true;
					break;
				}
			}
			if (matches) {
				builder.append(emp.toString());
			} else {
				builder.append(line);
			}
			builder.append("\n");
			line = reader.readLine();
		}
		reader.close();
		
		//Now, open the same file and rewrite the file. It replaces old content with newly replaced content
		BufferedWriter bw = new BufferedWriter(new FileWriter("employee.txt"));
		bw.write(builder.toString());
		bw.write("\n");
		bw.flush();
		
		bw.close();
		
	}
	
	@Override
	public List<Employee> viewAll() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("employee.txt"));
		String line = reader.readLine();
		
		while (line != null) {
			System.out.println(line);
			line = reader.readLine();
		}
		return null;
	}
	
	//File Storage
	
	@Override
	public
	Employee searchById(Integer id) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("employee.txt"));
		
		String line = reader.readLine();
		Employee emp = null;
		
		while (line != null) {
			boolean matches = false;
			String[] values = line.split(", ");
			
			String firstName = null;
			String lastName = null;
			Gender g = null;
			EmployeeType type = null;
			
			for (String val : values) {
				if (val.contains("id") && val.equals("id=" + id)) {
					matches = true;
				}
				
				if (val.contains("id=")) {
					String vals[] = val.split("=");
					id = Integer.parseInt(vals[1]);
				} else if (val.contains("firstName=")) {
					String vals[] = val.split("=");
					firstName = vals[1];
				} else if (val.contains("lastName=")) {
					String vals[] = val.split("=");
					lastName = vals[1];
				} else if (val.contains("gender=")) {
					String vals[] = val.split("=");
					String gender = vals[1];
					g = Gender.getByValue(gender);
				} else if (val.contains("employeeType=")) {
					String vals[] = val.split("=");
					String employeeType = vals[1];
					type = EmployeeType.getByValue(employeeType);
				}
			}
			
			if (matches) {
				emp = new Employee();
				emp.setId(id);
				emp.setFirstName(firstName);
				emp.setLastName(lastName);
				emp.setGender(g);
				emp.setEmployeeType(type);
				return emp;
			}
		}
		return emp;
	}
	
	@Override
	public Employee searchByUsernameAndPassword(String username, String password) throws IOException {
		System.out.println("Inside search by username and password method.. EmployeeDao method.. File store");
		BufferedReader reader = new BufferedReader(new FileReader("employee.txt"));
		
		String line = reader.readLine();
		Employee emp = null;
		
		while (line != null) {
			int count = 0;
			String[] values = line.split(", ");
			
			String firstName = null;
			String lastName = null;
			Integer id = null;
			Gender g = null;
			EmployeeType type = null;
			
			for (String val : values) {
				if (val.equals("username=" + username)) {
					count++;
				} else if (val.equals("password=" + password)) {
					count++;
				}
				
				if (val.contains("id=")) {
					String vals[] = val.split("=");
					id = Integer.parseInt(vals[1]);
				} else if (val.contains("firstName=")) {
					String vals[] = val.split("=");
					firstName = vals[1];
				} else if (val.contains("lastName=")) {
					String vals[] = val.split("=");
					lastName = vals[1];
				} else if (val.contains("gender=")) {
					String vals[] = val.split("=");
					String gender = vals[1];
					g = Gender.getByValue(gender);
				} else if (val.contains("employeeType=")) {
					String vals[] = val.split("=");
					String employeeType = vals[1];
					type = EmployeeType.getByValue(employeeType);
				}
			}
			
			if (count == 2) {
				emp = new Employee();
				emp.setId(id);
				emp.setFirstName(firstName);
				emp.setLastName(lastName);
				emp.setGender(g);
				emp.setEmployeeType(type);
				emp.setUsername(username);
				emp.setPassword(password);
				return emp;
			}
			
			line = reader.readLine();
			
		}
		reader.close();
		return emp;
	}
	
	@Override
	public Employee addEmployee(Employee emp) throws IOException {
		//Count number of lines in file and generate id based on that
		BufferedReader reader = new BufferedReader(new FileReader(new File("employee.txt")));
		int count = (int) reader.lines().count();
		emp.setId(++count);
		reader.close();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("employee.txt", true));
		bw.write(emp.toString());
		//		bw.newLine();
		bw.write("\n");
		bw.flush();
		

		bw.close();
		return emp;
	}
	
	@Override
	public Employee searchByUsername(String username) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("employee.txt"));
		
		String line = reader.readLine();
		Employee emp = null;
		
		while (line != null) {
			int count = 0;
			String[] values = line.split(", ");
			
			String firstName = null;
			String lastName = null;
			Integer id = null;
			Gender g = null;
			EmployeeType type = null;
			
			for (String val : values) {
				if (val.contains("username") && val.equals("username=" + username)) {
					count++;
				}
				if (val.contains("id=")) {
					String vals[] = val.split("=");
					id = Integer.parseInt(vals[1]);
				} else if (val.contains("firstName=")) {
					String vals[] = val.split("=");
					firstName = vals[1];
				} else if (val.contains("lastName=")) {
					String vals[] = val.split("=");
					lastName = vals[1];
				} else if (val.contains("gender=")) {
					String vals[] = val.split("=");
					String gender = vals[1];
					g = Gender.getByValue(gender);
				} else if (val.contains("employeeType=")) {
					String vals[] = val.split("=");
					String employeeType = vals[1];
					type = EmployeeType.getByValue(employeeType);
				}
			}
			
			if (count == 1) {
				emp = new Employee();
				emp.setId(id);
				emp.setFirstName(firstName);
				emp.setLastName(lastName);
				emp.setGender(g);
				emp.setEmployeeType(type);
				emp.setUsername(username);
				return emp;
			}
			
			line = reader.readLine();
			
		}
		
		reader.close();
		return emp;
	}
	
	@Override
	public void removeEmployee(String id) throws IOException {
		//Find the line, store it in string builder and replace the content with empty string
		BufferedReader reader = new BufferedReader(new FileReader("employee.txt"));
		
		String line = reader.readLine();
		StringBuilder builder = new StringBuilder();
		while (line != null) {
			String[] values = line.split(", ");
			boolean matches = false;
			for (String val : values) {
				if (val.contains("id") && val.equals("id=" + id)) {
					matches = true;
					break;
				}
			}
			if (matches) {
				builder.append("");
			} else {
				builder.append(line);
			}
			builder.append("\n");
			line = reader.readLine();
		}
		reader.close();
		
		//Now, open the same file and rewrite the file. It replaces old content with newly replaced content
		BufferedWriter bw = new BufferedWriter(new FileWriter("employee.txt"));
		bw.write(builder.toString());
		bw.write("\n");
		bw.flush();
		
		bw.close();
	}
	
}
