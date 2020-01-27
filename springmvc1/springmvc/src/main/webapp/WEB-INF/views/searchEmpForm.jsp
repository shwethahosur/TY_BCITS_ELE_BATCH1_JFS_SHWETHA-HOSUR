<%@page import="com.bcits.springmvc1.bean.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp" />

<%EmployeeInfoBean employeeInfoBean=(EmployeeInfoBean)request.getAttribute("employeeInfoBean");
	String errmsg=(String)request.getAttribute("errmsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
	<legend>Search Employee</legend>
	<form action="./search">
	EmployeeID:<input type="text" name="empid" required="required"><br>
	<input type="submit" value="search">
	</form>
	</fieldset>
	<%if(errmsg!=null && !errmsg.isEmpty()) {%>
	
		<h2 style="color: red"><%=errmsg %></h2>
	<%} %>
	
	
	<%if(employeeInfoBean!=null){ %>
	
		<table border="1"style="width: 70%">
			<tr style="background-color: navy;color: pink">
				<th>Employee Id</th>
				<th>name</th>
				<th>designation</th>
				<th>dob</th>
				<th>salary</th>
				<th>mobileno</th>
			</tr>
			<tr>
				<td><%=employeeInfoBean.getEmpid() %></td>
				<td><%=employeeInfoBean.getName() %></td>
				<td><%=employeeInfoBean.getDesignation() %></td>
				<td><%=employeeInfoBean.getDateOfBirth() %></td>
				<td><%=employeeInfoBean.getSalary() %></td>
				<td><%=employeeInfoBean.getMobileno() %></td>
			
			</tr>
		</table>
	<%} %>
</body>
</html>
<jsp:include page="footer.jsp" />