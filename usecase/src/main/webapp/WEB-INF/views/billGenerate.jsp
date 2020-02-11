<%@page import="com.bcits.usecase.beans.ConsumerCurrentBill"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	ConsumerCurrentBill consumerCurrentBill = (ConsumerCurrentBill) request.getAttribute("consumerCurrentBill");
	String msg = (String) request.getAttribute("msg");
	String errMsg = (String) request.getAttribute("errMsg");
%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<spring:url var="css" value="/resources/css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill Generation</title>
<link rel="stylesheet" href="${css}/billGenerate.css">
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
	<%-- <%-- <%
		if (consumerCurrentBill != null) {
	%> --%> --%>
	<div class="container-fluid">

		<div class="row">

			<div
				class="col-xs-12 col-sm-12 col-md-6 col-md-offset-3 col-lg-6 col-lg-offset-3 reducedCol well text-center">
				<form action="./BillGenerated" method="post" class="form">
					<br>

					<fieldset class="form-group">
						<br> <label for="rrNo">R.R No</label><br> <input
							class="form-control inp" name="rrNo" type="text"
							value="<%-- <%=consumerCurrentBill.getRrNo()%> --%>" placeholder="rrno"><br>
						<br>

					</fieldset>
					<fieldset class="form-group">
						<br> <label for="curr">Current Reading</label><br> <input
							class="form-control inp" name="currentMeterReading" type="number"
							value="<%-- <%=consumerCurrentBill.getCurrentMeterReading()%> --%>"
							placeholder="Units in kWh"><br> <br> <label
							for="prev">Previous Reading</label> <br> <input
							class="form-control inp" name="previousMeterReading"
							type="number"
							value="<%=consumerCurrentBill.getPreviousMeterReading()%>"
							placeholder="Units in kWh"><br> <label for="curr">units</label><br>
						<br> <input class="form-control inp" name="units"
							type="number" value="<%-- <%=consumerCurrentBill.getUnits()%> --%>"
							placeholder="Units in kWh">

					</fieldset>
					<br>

					<fieldset class="form-group form-inline">
						<br> <label for="startDate">Start Date</label><br> <input
							class="form-control inp" name="previousMeterReadDate" type="date"
							value="<%-- <%=consumerCurrentBill.getPreviousMeterReadDate()%> --%>"><br>
						<br> <label for="endDate">End Date</label><br> <input
							class="form-control inp" name="currentMeterReadDate" type="date"
							value="<%-- <%=consumerCurrentBill.getCurrentMeterReadDate()%> --%>"><br>
						<label for="endDate">Due Date</label><br> <input
							class="form-control inp" name="dueDate" type="date"
							value="<%-- <%=consumerCurrentBill.getDueDate()%> --%>">
					</fieldset>
					<br> <br>
					<fieldset class="form-group">
						<br>
						<button class="btn bg-primary getButton" type="button" style="">Generate
							Bill</button>
						<br> <br>
					</fieldset>
					<br>
				</form>
				
				<br>
			</div>
</body>
</html>