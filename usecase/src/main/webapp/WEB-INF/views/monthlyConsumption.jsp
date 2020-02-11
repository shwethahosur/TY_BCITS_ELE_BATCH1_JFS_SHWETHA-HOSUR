<%@page import="java.util.List"%>
<%@page import="com.bcits.usecase.beans.ConsumerInfoBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bcits.usecase.beans.MonthlyConsumption"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<jsp:include page="sidebar.jsp" />
<%
	ConsumerInfoBean consumerInfoBean = (ConsumerInfoBean) session.getAttribute("loggedInConsInfo");
	List<MonthlyConsumption> monList = (List<MonthlyConsumption>) request.getAttribute("monthlyConsumption");
%>
<%
	String msg = (String) request.getAttribute("msg");
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
	<%
		if (monList != null)
			for (MonthlyConsumption list : monList) {
	%>
	<%
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	%>
	<table>
		<tr>
			<th>Date</th>
			<th>TotalBill</th>
			<th>Region</th>
			<th>Units</th>
		</tr>
		<tr>
			<td><%=format.format(list.getConsumptionPK().getDate())%></td>
			<td><%=list.getBillAmount()%></td>
			<td><%=list.getRegion()%></td>
			<td><%=list.getUnitsConsumed()%></td>
		</tr>
	</table>
	<%
		}
	%>
</body>
</html>