<%@page import="java.util.ArrayList"%>
<%@page import="ems.Employee"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Employee</title>
</head>
<body>

	<h1> Employee</h1>
	
	<a href="/ems/register" >Register</a>
	<br>
	<br>
	<br>
	
	<a href="/ems/register?id=1"> Do Something </a>
	
	<table border="1">
		<tr>
				<th>
					SN
				</th>
				<th>
					First Name
				</th>
				<th>
					Last Name
				</th>
				<th>
					Gender
				</th>
				<th>
					Username
				</th>
				<th>
					Employee Type
				</th>
				<th>
				</th>
				<th>
				</th>
		</tr>
		
	
	
	<%
		List<Employee> emps = (List<Employee>) request.getAttribute("employees");
		
		for (Employee emp: emps) {
			out.print("<tr>");
			out.print("<td>"+emp.getId() + "</td>");
			out.print("<td>"+emp.getFirstName() + "</td>");
			out.print("<td>"+emp.getLastName() + "</td>");
			out.print("<td>"+emp.getGender() + "</td>");
			out.print("<td>"+emp.getUsername() + "</td>");
			out.print("<td>"+emp.getEmployeeType() + "</td>");
			out.print("<td> <a href='/ems/register?id="+emp.getId() +"'> Edit </a></td>");
			out.print("<td> Delete </td>");
			out.print("</tr>");
		}
	%>
	
	</table>
	

</body>
</html>