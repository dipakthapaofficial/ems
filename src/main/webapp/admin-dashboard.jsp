<%@page import="ems.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Dashboard</title>
</head>
<body>

<h1> This is an admin dashboard.</h1>


<div style="float='right';">
	<%
		Employee emp = (Employee) request.getSession().getAttribute("user");
		out.print(emp.getUsername());
		out.print(emp.getId());
	
	%>
</div>

<a href="/ems/logout">Logout</a>

</body>
</html>