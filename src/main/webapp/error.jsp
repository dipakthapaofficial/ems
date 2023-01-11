<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
	
	<h1>Some Error Occurred</h1>
	<%
		String internalError = (String) request.getAttribute("internalError");
		if (internalError != null && internalError != "") {
			out.print("<span style='color:red;'>");
			out.print(internalError);
			out.print("</span><br/>");
		}
	%>
	

</body>
</html>