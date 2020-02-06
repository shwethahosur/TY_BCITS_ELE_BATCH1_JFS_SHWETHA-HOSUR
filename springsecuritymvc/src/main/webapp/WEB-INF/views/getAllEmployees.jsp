<%@page import="com.bcits.springsecuritymvc.beans.EmpInfoBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <% List<EmpInfoBean> employeeList=(List<EmpInfoBean>) request.getAttribute("employeeList"); %>
    <jsp:include page="header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>search all Employees</title>
</head>
<body>
<div>
<%  if (employeeList!=null && !employeeList.isEmpty()){ %>
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
	<%for(EmpInfoBean empInfo:employeeList) {%>
	<td> <%= empInfo.getEmpId()%></td><br>
	<td><%=  empInfo.getName() %></td><br>
	<td><%=  empInfo.getPassword() %></td><br>
	<td><%=  empInfo.getRole() %></td><br>
	</tr>
	<% }%>
	</tbody>
	</table>
	<% } else{ %>
	<h2 style="color:red;"> empid not found</h2> 
	<% } %>

</body>
</html>