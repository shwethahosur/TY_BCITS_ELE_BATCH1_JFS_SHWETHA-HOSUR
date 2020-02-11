<%@page import="com.bcits.usecase.beans.ConsumerCurrentBill"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="sidebar.jsp" />
<%
	ConsumerCurrentBill consumerCurrentBill = (ConsumerCurrentBill) request.getAttribute("consumerCurrentBill");
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
	width:50%;
}

th, td {
	padding: 15px;
	text-align: left;
}

table {
	width:500px;
	background-color: #f1f1c1;
	align: centre;
	margin-left: 400px;
	margin-right: 100px;
}

body {
	background-color: rgb(205, 133, 63);
}
</style>


</head>
<body>
	<fieldset>
		<legend>View Bill</legend>
		<form action="./bill">
			R.R.Number:<input type="text" name="rrNo" required="required"><br>
			<input type="submit" value="search">
		</form>
	</fieldset>

	<%
		if (errMsg != null && !errMsg.isEmpty()) {
	%>

	<h2 style="color: red"><%=errMsg%></h2>
	<%
		}
	%>


	<%
		if (consumerCurrentBill != null) {
	%>

	<table>
		<tr>
			<th>R.R Number</th>
			<th>Meter Number</th>

			<th>Bill Number</th>
			<th>Bill Date</th>
			
			
			
			<th>Units</th>
			<th>Meter Status</th>
			<th>Bill</th>
			<th>Due Date</th>
		</tr>
		<tr>
			<td><%=consumerCurrentBill.getRrNo()%></td>
			<td><%=consumerCurrentBill.getMeterNo()%></td>
			<td><%=consumerCurrentBill.getBillNumber()%></td>
			
			<td><%=consumerCurrentBill.getCurrentMeterReadDate()%></td>
			
			<td><%=consumerCurrentBill.getUnits()%></td>
			<td><%=consumerCurrentBill.getMeterStatus()%></td>
			<td><%=consumerCurrentBill.getPayableAmt()%></td>
			<td><%=consumerCurrentBill.getDueDate()%></td>
		</tr>
	</table>
	<%
		}
	%>
</body>

</html>