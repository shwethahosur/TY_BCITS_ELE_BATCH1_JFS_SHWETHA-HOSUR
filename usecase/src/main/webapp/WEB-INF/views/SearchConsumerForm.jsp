<%@page import="com.bcits.usecase.beans.ConsumerInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="sidebar.jsp" />
<%
	ConsumerInfoBean consumerInfoBean = (ConsumerInfoBean) request.getAttribute("consumerInfoBean");

	String Msg = (String) request.getAttribute("Msg");
	String errMsg = (String) request.getAttribute("errMsg");
%>
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
	margin-left: 400px;
}

body {
	background-color: rgb(205, 133, 63);
}
</style>



</head>
<body>
	<fieldset>
		<legend>Search Consumer</legend>
		<form action="./search">
			MeterNo:<input type="text" name="meterNo" required="required"><br>
			<input type="submit" value="search">
		</form>
	</fieldset>
	<%
		if (consumerInfoBean != null) {
	%>

	<table>
		<tr>
			<th>FirstName</th>
			<th>LastName</th>
			<th>MeterNo</th>
			<th>Email-Id</th>
			<th>MobileNo</th>
			<th>Address</th>
			<th>Pincode</th>
			<th>Consumertype</th>
			<th>Region</th>
			<th>R.R No</th>
		</tr>
		<tr>
			<td><%=consumerInfoBean.getFirstName()%></td>
			<td><%=consumerInfoBean.getLastName()%></td>
			<td><%=consumerInfoBean.getMeterNo()%></td>
			<td><%=consumerInfoBean.getEmail()%></td>
			<td><%=consumerInfoBean.getMobileNo()%></td>
			<td><%=consumerInfoBean.getAddress()%></td>
			<td><%=consumerInfoBean.getPincode()%></td>
			<td><%=consumerInfoBean.getConsumertype()%></td>
			<td><%=consumerInfoBean.getRegion()%></td>
			<td><%=consumerInfoBean.getRrNo()%>
		</tr>
	</table>
	<%
		}
	%>
	<%
		if (Msg != null && !Msg.isEmpty()) {
	%>
	<h4 style="color: green;"><%=Msg%></h4>
	<%
		}
	%>
	<%-- <%
		if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<h4 style="color: red;"><%=errMsg%></h4>
	<% --%>
	<!-- 	}
	%> -->
</body>
</html>