
<%@page import="com.bcits.springsecuritymvc.beans.EmpInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% EmpInfoBean  empInfo=(EmpInfoBean)request.getAttribute("empInfo"); %>
   <jsp:include page="header.jsp"/> 
 
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<fieldset style="width:60%">
		<legend>search employee</legend>
		<form action="./getEmployee">
			<label>employee id:</label> <input type="text" name="empId" required="required">
			&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" value="search">
		</form>

	</fieldset>
	<%  if (empInfo!=null){ %>
	<table>
	<thead>
	<tr style="background:navy;color:white;">
	<th>Employee Id</th>
	<th>Employee Name</th>
	<th>Password</th>
	<th>Role</th>
	</tr>
	</thead>
	<tbody>

	<td><%= empInfo.getEmpId()%></td><br>
	<td><%=  empInfo.getName() %></td><br>
	<td><%=  empInfo.getPassword() %></td><br>
	<td><%=  empInfo.getRole() %></td><br>
	<% } else{ %>
	<!-- <h2 style="color:red;"> empid not found</h2> -->
	<% } %>
	</div>
	</tbody>
		</table>
	
</body>
</html>