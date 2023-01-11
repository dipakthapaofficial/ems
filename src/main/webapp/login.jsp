<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%
		String errorMessage = (String) request.getAttribute("error");
		if (errorMessage != null && errorMessage != "") {
			out.print("<span style='color:red;'>");
			out.print(errorMessage);
			out.print("</span> <br/>");
		}
	%>
	
	<form action="/ems/login1" method="post">
		<label for="username">Username</label>
		 <input type="text" name="username" value="${username1}" />
		<br /><br/>
		<label for="password">Password</label>
		<input type="password" name="password123" value="${password1}" />
		<input type="submit" value="Submit" />
		
	</form>

</body>
</html>