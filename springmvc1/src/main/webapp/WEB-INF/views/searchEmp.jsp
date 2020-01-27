<%@page import="com.bcits.springmvc1.bean.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<% EmployeeInfoBean employeeInfoBean=(EmployeeInfoBean)request.getAttribute("employeeInfoBean"); 
	String errmsg=(String)request.getAttribute("errmsg");
	
	%>

<jsp:include page="header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>search</legend>
		<form action="./search">
			Employee ID:<input type="text" name="empid" required>
			&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" value="search">

		</form>
	</fieldset>
	
	<% if(employeeInfoBean!=null){ %>
	<div align="center">
	<table border="1" style="width:70%">
	
	<tr style="background:navy;color:white;">
	<th>Emp id</th>
	<th>Emp name</th>
	<th>Emp designation</th>
	<th>Emp mobile</th>
	</tr>
	<tr>
	<td><%=employeeInfoBean.getEmpid() %></td>
	<td><%=employeeInfoBean.getName() %></td>
	
	</tr>
	</table>
	<%} %>
	</div>
	
	
</body>
</html>
<jsp:include page="Footer.jsp"/>