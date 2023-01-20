<%@page import="java.util.Arrays"%>
<%@page import="ems.Gender"%>
<%@page import="java.util.Date"%>
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

</head>
<body>

	<h1>Employee</h1>
	
	<%-- <%
	//Used to display message from edit method, which is forwarded by request dispatcher
	String message = (String) request.getAttribute("message");
	if (message != null && message != "") {
		out.print("<span style='color:green;'>");
		out.print(message);
		out.print("</span><br/><br/><br/><br/>");
	}
	%> --%>

	<%-- <%
	//Used to success message from delete method
	message = (String) request.getParameter("message");
	if (message != null && message != "") {
		out.print("<span style='color:green;'>");
		out.print(message);
		out.print("</span><br/><br/><br/><br/>");
	}
	%>
	 --%>
	 
	 <sql:setDataSource var="con" password="root" driver="com.mysql.cj.jdbc.Driver" user="root" url="jdbc:mysql://localhost:3306/ems"/>
	 
	 <sql:query var="resultSet" dataSource="${con}">
	 	select * from employee;
	 	
	 </sql:query>
	 
	<c:forEach var="row" items="${resultSet.rows}">
		<span>${row.first_name}</span>
		<span>${row.last_name}</span>
		<br>
	</c:forEach>	 
	 
	<c:if test="${message != null && message != ''}">
	
		<span style="color:green;">${message }</span><br/><br/><br/><br/>
	</c:if>
	
	<%-- <c:choose>
		
			<c:when test=""></c:when>
			<c:when test=""></c:when>
			<c:when test=""></c:when>
			<c:when test=""></c:when>
			<c:when test=""></c:when>
			<c:otherwise></c:otherwise>
		</c:choose> --%>
		
		
	<a href="/ems/register">Register</a>
	<br>
	<br>
	<br>
	<%
		Date joinDate = new Date();
		pageContext.setAttribute("regDate", joinDate);
		
	%>

	<table border="1">
		<tr>
			<th>SN</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Gender</th>
			<th>Username</th>
			<th>Employee Type</th>
			<c:if test="${user.employeeType == 'ADMIN'}">
				<th>Salary</th>
			</c:if>
			<th>Join Date</th>
			<c:if test="${user.employeeType == 'ADMIN'}">
				<th></th>
				<th></th>
			</c:if>
			
		</tr>
		
		<c:forEach var="emp" items="${employees}">
			<tr>
				<td>${emp.id}</td>
			
				<td>	<c:out value="${fn:toUpperCase(emp.firstName) }" /></td>
				<td>${emp.lastName}</td>
				<td>${emp.gender}</td>
				<td>${emp.username}</td>
				<td>${emp.employeeType}</td>
				<c:if test="${user.employeeType == 'ADMIN'}">
					<td><fmt:formatNumber currencySymbol="$" type="currency">10000000</fmt:formatNumber></td>
				</c:if>
				<td><fmt:formatDate value="${regDate}" /></td>
				
				<c:if test="${user.employeeType == 'ADMIN'}">
					<td><a href="<c:url value='register?id=${emp.id}' /> " > Edit </a></td>
					<td><a href="/register?id=${emp.id} "> Edit </a></td>
					<td>
						<form action='/ems/employee' method='post'>
							<input type='hidden' name='method' value='delete'> 
							<input type='hidden' name='id' value='${emp.id}' /> 
							<input type='submit' value='Delete'>
						</form>
					</td>
				</c:if>
				
				
			</tr>
		</c:forEach>


		<%-- <%
		List<Employee> emps = (List<Employee>) request.getAttribute("employees");

		for (Employee emp : emps) {
			out.print("<tr>");
			out.print("<td>" + emp.getId() + "</td>");
			out.print("<td>" + emp.getFirstName() + "</td>");
			out.print("<td>" + emp.getLastName() + "</td>");
			out.print("<td>" + emp.getGender() + "</td>");
			out.print("<td>" + emp.getUsername() + "</td>");
			out.print("<td>" + emp.getEmployeeType() + "</td>");
			out.print("<td> <a href='/ems/register?id=" + emp.getId() + "'> Edit </a></td>");
			out.print(
			"<td> <form action='/ems/employee' method='post'><input type='hidden' name='method' value='delete'> <input type='hidden' name='id' value='"
					+ emp.getId() + "'/> <input type='submit' value='Delete'></form></td>");
			out.print("</tr>");
		}
		%> --%>

	</table>


</body>
</html>