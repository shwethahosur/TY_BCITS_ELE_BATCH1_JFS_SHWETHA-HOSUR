<%@page import="com.bcits.springmvc1.bean.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% EmployeeInfoBean bean=(EmployeeInfoBean)session.getAttribute("loggedInEmpInfo") ;%>
    <jsp:include page="header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:purple;">welcome<%=bean.getName() %></h1>
</body>
</html>
<jsp:include page="Footer.jsp"/>