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
	
	<%
		//Used to display message from edit method, which is forwarded by request dispatcher
		String message = (String) request.getAttribute("message");
		if (message != null && message != "") {
			out.print("<span style='color:green;'>");
			out.print(message);
			out.print("</span><br/><br/><br/><br/>");
		}
	%>
	
	<%
		//Used to success message from delete method
		message = (String) request.getParameter("message");
		if (message != null && message != "") {
			out.print("<span style='color:green;'>");
			out.print(message);
			out.print("</span><br/><br/><br/><br/>");
		}
	%>
	
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
			out.print("<td> <form action='/ems/employee' method='post'><input type='hidden' name='method' value='delete'> <input type='hidden' name='id' value='"+emp.getId() +"'/> <input type='submit' value='Delete'></form></td>");
			out.print("</tr>");
		}
	%>
	
	</table>
	

</body>
</html>