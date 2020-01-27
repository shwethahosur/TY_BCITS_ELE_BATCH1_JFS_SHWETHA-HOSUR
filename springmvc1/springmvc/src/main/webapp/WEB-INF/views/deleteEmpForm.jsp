<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="header.jsp" />
   <% String msg=(String) request.getAttribute("msg");
   String errmsg=(String) request.getAttribute("errmsg");
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Employee portal</title>
</head>
<body>
	<fieldset>
	<legend>Delete Employee</legend>
	<form action="./delete">
	EmployeeID:<input type="text" name="empid" required="required"><br>
	<input type="submit" value="delete">
	</form>
	</fieldset>
	
	<%if(msg!=null && !msg.isEmpty()){ %>
	
		<h3 style="color: green"><%=msg %></h3>
		
	<%} %>
	
	<%if(errmsg!=null && !errmsg.isEmpty()){ %>
	
		<h3 style="color: red"><%=errmsg %></h3>
		
	<%} %>
	<jsp:include page="footer.jsp" />
</body>
</html>