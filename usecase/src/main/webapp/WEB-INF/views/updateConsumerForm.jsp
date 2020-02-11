<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="sidebar.jsp" />
<%
	String msg = (String) request.getAttribute("msg");
	String errMsg = (String) request.getAttribute("errMsg");
%>
<%-- <jsp:include page="header.jsp"></jsp:include> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 15px;
	text-align: left;
}

table {
	width: 50%;
	background-color: #f1f1c1;
	align: centre;
	margin-left: 500px;
}

body {
	background-color: rgb(205, 133, 63);
}
</style>



</head>
<body>

	<%
		if (msg != null && !msg.isEmpty()) {
	%>

	<h2 style="color: green"><%=msg%></h2>
	<%
		}
	%>
	<%
		if (errMsg != null && !errMsg.isEmpty()) {
	%>

	<h2 style="color: red"><%=errMsg%></h2>
	<%
		}
	%>
	<fieldset>
		<legend>update Consumer</legend>

		<form action="./updateConsumer" method="post">
			<table>
				<tr>
					<td>Meter Number</td>
					<td>:</td>
					<td><input type="number" name="meterNo" required></td>
				</tr>
				<tr>
					<td>FirstName</td>
					<td>:</td>
					<td><input type="text" name="firstName"></td>
				</tr>
				<tr>
					<td>LastName</td>
					<td>:</td>
					<td><input type="text" name="lastName"></td>
				</tr>
				<tr>
					<td>Mobile NO</td>
					<td>:</td>
					<td><input type="number" name="mobileNo"></td>
				</tr>

				<tr>
					<td>Email</td>
					<td>:</td>
					<td><input type="email" name="email"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="userPassword"></td>
				</tr>
				<tr>
					<td>Address</td>
					<td>:</td>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<td colspan="3"><br> <input type="submit" value="update">
					</td>

				</tr>


			</table>

		</form>
	</fieldset>
</body>
</html>
<%-- <jsp:include page="footer.jsp"></jsp:include> --%>