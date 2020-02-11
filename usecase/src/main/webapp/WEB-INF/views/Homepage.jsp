<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
	String Msg = (String) request.getAttribute("Msg");
	String errMsg = (String) request.getAttribute("errMsg");
%>

<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<spring:url var="css" value="/resources/css" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {background ="${images
	
}
/
pic7
.jpg
"
 
;
}
</style>




<link rel="stylesheet" href="${css}/home.css">






</head>
<body>
	<col>
	<div class="sidebar">
		<header>My App</header>
		<ul>
			<li><a href="./homepage"><i class="fas fa-qrcode"></i>HOME</a></li>
			<li><a href="#"><i class="fas fa-link"></i> ABOUT US</a></li>
			<li><a href="#"><i class="fas fa-stream"></i></a></li>
			<li><a href="#"><i class="fas fa-calendar-week"></i>CONTACT
					US</a></li>
			<li><a href="#"><i class="fas fa-question-circle"></i>HELP</a></li>

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
	<div class="row">
		<div class="column">
			<label for="cons">Consumer</label>
		</div>
		<div class="column">
			<a href="./signup"><img
				src="${images}/390-3904748_debt-consolidation-program-or-consumer-proposal-cartoon-clipart.png"
				alt="Snow">
		</div>
		<div class="column">
			<label for="Admin">Admin</label>
		</div>
		<div class="column">
			<a href="./adminlogin"><img src="${images}/Training.png"
				alt="Forest">
		</div>
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