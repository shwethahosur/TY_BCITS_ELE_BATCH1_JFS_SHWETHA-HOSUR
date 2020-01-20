<%@page import="java.util.List"%>
<%@page import="com.bcits.bean.Test1"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	List<Test1> testlist = (List<Test1>) request.getAttribute(" employeeList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		if (testlist != null) {
	%>
	<table border="1" style="width: 80%;">
		<thead style="background: navy; color: white;">
			<tr style="height: 35px">
				<th>Employee id</th>
				<th>Employee name</th>
				<th>Employee salary</th>
				<th>Employee designation</th>
				<th>Employee dob</th>
				<th>Employee doj</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Test1 t: testlist) {
			%>
			<tr style="height: 25px">
				<td><%=t.getEmpid()%></td>
				<td><%=t.getEmpname()%></td>
				<%-- <td><%= t.getEmpid() %></td>
  <td><%= t.getEmpid() %></td> --%>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<%
		} else {
	%>
	<h2>not found</h2>
	<%} %>

</body>
</html>