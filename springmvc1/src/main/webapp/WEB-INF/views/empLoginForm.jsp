<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%String errmsg=(String)request.getAttribute("errmsg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% if(errmsg!=null && !errmsg.isEmpty()){ %>
<h2 style="color:red;"><%=errmsg %></h2>
<%} %>

	<fieldset>
		<legend>Employee Login</legend>
		
		<form action="./login" method="post">
			<table>
				<tr>
					<td>Employee Id</td>
					<td>:</td>
					<td><input type="text" name="empid"></td>
				</tr>
				<tr>
					<td>password</td>
					<td>:</td>
					<td><input type="password" name="password"></td>
				</tr>
				
				
				<tr>
					<td colspan="3" align="center"><br>
					 <input type="submit"></td>
				</tr>
			</table>
		</form>


	</fieldset>
</body>
</html>

<jsp:include page="Footer.jsp"></jsp:include>