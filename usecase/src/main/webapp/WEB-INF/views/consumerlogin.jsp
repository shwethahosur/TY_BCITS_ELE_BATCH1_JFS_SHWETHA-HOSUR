<%@page import="com.bcits.usecase.beans.ConsumerInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
	
%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<jsp:include page="sidebar.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${css}/consumerlogin.css">
<style>
body {
	background-color: rgb(205, 133, 63);
}
</style>
</head>
<body>
	<div class="card col-md-6 col-sm-6 col-6 col-lg-6 col-xl-6"></div>
	<form action="./login" method="post">
		<pre>
			<h2> Customer Portal Login</h2>
		</pre>
		<label for=""> Meter Number</label><br> <input type="text"
			name="meterNo" id="mn" placeholder="Enter your meter number" required><br>
		<br> <label for=""> Password</label><br> <input
			type="password" name="password" id="pw"
			placeholder="Enter your password" required><br>
		<br>
		<button type="submit">Login</button>
		<br>
		<p>Forgot your password?</p>
	</form>
	<br>
	<form action="./signup">
		<input type="submit" value="signUp">
	</form>
</body>
</html>