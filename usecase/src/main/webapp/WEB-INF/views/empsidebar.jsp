<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
	String Msg = (String) request.getAttribute("Msg");
	String errMsg = (String) request.getAttribute("errMsg");
%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${css}/consumerhome.css">
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>
<body>
	<div class="sidebar">
		<header>discom</header>
		<ul>

			<li><a href="./employeelogin"><i class="fas fa-link"></i>
					Login</a></li>
			<li><a href="./getregionConsumers"><i class="fas fa-stream"></i>View
					Consumers</a></li>
			<li><a href="./billUpdatePage"><i class="fas fa-stream"></i>View
					Bill</a></li>
			<li><a href="./empmonthlyConsumption"><i
					class="fas fa-stream"></i>Monthly Consumption</a></li>
			<li><a href="./viewComments"><i class="fas fa-stream"></i>View
					Comments </a></li>
			<li><a href="./empLogoutPage"><i class="fas fa-stream"></i>logout</a></li>
		</ul>
	</div>
	<div>
		<marquee class="marq" direction="left" loop="">
			<div class="geek1">
				<h1>welcome to discom......</h1>
			</div>
			<div class="geek2">light up your life</div>
		</marquee>
	</div>
	<%
		if (Msg != null && !Msg.isEmpty()) {
	%>
	<h4 style="color: green;"><%=Msg%></h4>
	<%
		}
	%>
	<%
		if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<h4 style="color: red;"><%=errMsg%></h4>
	<%
		}
	%>
</body>
</html>