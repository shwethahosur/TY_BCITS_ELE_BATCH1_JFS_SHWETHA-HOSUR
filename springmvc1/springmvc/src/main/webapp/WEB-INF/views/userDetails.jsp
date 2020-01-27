<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%int empid=(Integer)request.getAttribute("empid");
    	String password=(String)request.getAttribute("pwd");    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	user id = <%=empid %><br>
	user password = <%=password %>
</body>
</html>