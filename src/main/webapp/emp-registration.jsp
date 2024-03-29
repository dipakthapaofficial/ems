<%@page import="java.util.Arrays"%>
<%@page import="ems.Gender"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<%
		if (request.getAttribute("id") != null && request.getAttribute("id") != "") {
			out.print(" <title>Employee Update</title>");
		} else {
			out.print("<title>Employee Registration</title>");
		}
	%>
	<%
		List<Gender> genders = Arrays.asList(Gender.values());
		pageContext.setAttribute("genders", genders);
	%>
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: black;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #04AA6D;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>
</head>
<body>

<%
		String internalError = (String) request.getAttribute("internalError");
		if (internalError != null && internalError != "") {
			out.print("<span style='color:red;'>");
			out.print(internalError);
			out.print("</span><br/>");
		}
	%>

<form action="/ems/register" method="post">
  <div class="container">
    
    <%
		if (request.getAttribute("id") != null && request.getAttribute("id") != "") {
			out.print("<h1>Update Employee</h1>");
		} else {
			out.print("<h1>Register</h1>");
		}
	%>
    <p>Please fill in this form to create an account.</p>
    <hr>
	
    <input type="hidden" name="id"  value="${id}" >
	
    <label for="firstName"><b>First Name</b></label>
    <input type="text" placeholder="Enter First Name" name="firstName" id="firstName"  value="${firstName}" required>
    
    <%-- <input type="text" placeholder="Enter First Name" name="firstName" id="firstName"  value="${employee.firstName}" required> --%>

   	<label for="lastName"><b>Last Name</b></label>
    <input type="text" placeholder="Enter lastName" name="lastName"  value="${lastName}" id="lastName" required>
    
    <label for="gender"><b>Gender</b></label>
    <select name="gender" value="${gender}" required>
    	<option value="">Select Gender</option>
    	<option value="MALE">MALE</option>
    	<option value="FEMALE">FEMALE</option>
    	<option value="OTHERS">OTHERS</option>
    </select>
     <br/><br/>
      <br/><br/>
      
    <select name="gender" value="${gender}" required>
    <option value="">Select Gender</option>
    <c:foreach var="gend" items="genders">
    	<option value="${gend.value}">${gend}</option>
    </c:foreach>
    
    <br/><br/>
    
    <%
		if (request.getAttribute("id") == null || request.getAttribute("id") == "") {
			out.print("<label for='username'><b>Username::</b></label>" +
				    "<input type='text' placeholder='Enter username' name='username' id='username' value=" +
				    		request.getAttribute("username") +" required><br>");
			
		}
	%>
    
    
    <%
		String errorMessage = (String) request.getAttribute("error");
		if (errorMessage != null && errorMessage != "") {
			out.print("<span style='color:red;'>");
			out.print(errorMessage);
			out.print("</span><br/>");
		}
	%>
    
    <label for="password"><b>Password::</b></label>
    <input type="password" placeholder="Enter password" name="password" id="password" value="${password}" required>
    
    <%
		if (request.getAttribute("id") != null && request.getAttribute("id") != "") {
			out.print(" <button type='submit' class='registerbtn'>Update</button>");
		} else {
			out.print(" <button type='submit' class='registerbtn'>Register</button>");
		}
	%>
	
	 <%-- <button type='submit' class='registerbtn'><%out.print(request.getAttribute("buttonName")); %></button>     --%>
	
   
  </div>
  
  <div class="container signin">
    <p>Already have an account? <a href="#">Sign in</a>.</p>
  </div>
</form>

</body>
</html>


</body>
</html>