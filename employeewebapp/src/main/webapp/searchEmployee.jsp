<%@page import="com.bcits.bean.Test1"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% Test1 test =(Test1) request.getAttribute("empinfo"); %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>
		<legend>search employee</legend>
		<form action="./getEmp">
			<label>employee id:</label> <input type="text" name="empid" required>
			&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" value="search">
		</form>

	</fieldset>
	
	
	<%  if (test!=null){ %>
	Name = <%= test.getEmpname() %><br>
	salary=<%= test.getEmpsalary() %><br>
	designation=<%= test.getEmpdesignation() %><br>
	<% } else{ %>
	<h2 style="color:red;"> empid not found</h2>
	<% } %>
</body>
</html>